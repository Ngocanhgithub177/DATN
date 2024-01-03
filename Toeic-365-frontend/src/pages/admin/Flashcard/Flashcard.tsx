import React, { useState, useEffect, useRef } from "react";

import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Toast } from "primereact/toast";
import { Button } from "primereact/button";
import { Toolbar } from "primereact/toolbar";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import { Dropdown } from "primereact/dropdown";
import { TimePicker } from "antd";
import moment from 'moment';
import 'antd/dist/antd.css';
import classNames from "classnames";

import * as FlashcardApi from "../../../apis/FlashcardApi";
import * as TypeWordApi from "../../../apis/TypeWordApi";

export const Flashcard = () => {

    let initialFlashcard = {
        id: '',
        word: '',
        content: '',
        image: '',
        nouns: '',
        typeword: 0
    };

    const toast = useRef(null);
    const data = useRef(null);
    const [imageData, setImageData] = useState("");
    const [flashcard, setFlashcard] = useState(initialFlashcard);
    const [flashcards, setFlashcards]: any = useState(null);
    const [types, setTypes]: any = useState([]);
    const [flashcardDialog, setFlashcardDialog] = useState(false);
    const [deleteFlashcardDialog, setDeleteFlashcardDialog] = useState(false);
    const [selectedFlashcards, setSelectedFlashcards]: any = useState(null);
    const [globalFilter, setGlobalFilter]: any = useState(null);

    const [submitted, setSubmitted] = useState(false);

    useEffect(() => {
        const getAll = async () => {
            try {
                const response = await FlashcardApi.getAll();
                setFlashcards(response.data);
                console.log(response.data);
            } catch (error : any) {
                console.log(error.message);
            }
        };

        getAll();
    }, []);

    useEffect(() => {
        const getAllType = async () => {
            try {
                const response = await TypeWordApi.getAll();
                setTypes(response.data);
                console.log(response.data);
            } catch (error : any) {
                console.log(error.message);
            }
        };
        getAllType();
    }, []);

    const saveExam = (e: any) => {
        e.preventDefault();

        setSubmitted(true);

        if (flashcard.content && flashcard.image && flashcard.nouns && flashcard.typeword && flashcard.word) {
            let _flashcards = [...flashcards];
            let _flashcard = { ...flashcard };
            const formData = new FormData();
            formData.append("word",_flashcard.word);
            formData.append("content",_flashcard.content);
            formData.append("nouns",_flashcard.nouns);
            formData.append("image",_flashcard.image);
            formData.append("typeword",_flashcard.typeword + '');
            if(_flashcard.id.length > 0){
                formData.append("id",_flashcard.id);
            }
            if (flashcard.id) {
                const index = findIndexById(flashcard.id);
                _flashcards[index] = _flashcard;

                FlashcardApi
                    .update(formData)
                    .then(() => {
                        // @ts-ignore
                        toast.current.show({ severity: "success", summary: "Successful", detail: "FlashCard Updated", life: 3000 });
                        window.location.reload();
                    })
                    .catch((error) => {
                        console.log(error.message);
                    })
            } else {
                FlashcardApi
                    .create(formData)
                    .then(() => {
                        // @ts-ignore
                        toast.current.show({ severity: "success", summary: "Successful", detail: "FlashCard Created", life: 3000 });
                        window.location.reload();
                    })
                    .catch((error) => {
                        console.log(error.message);
                    })
                _flashcards.push(_flashcard);
            }

            setFlashcards(_flashcards);
            setFlashcardDialog(false)
            setFlashcard(initialFlashcard);
        }
    };

    const findIndexById = (id: any) => {
        let index = -1;
        for (let i = 0; i < flashcards.length; i++) {
            if (flashcards[i].id === id) {
                index = i;
                break;
            }
        }

        return index;
    };



    const onInputChange = (e: any, name: any) => {
        setFlashcard({ ...flashcard, [`${name}`]: e.target.value });
    };

    const handleImageChange = (e: any ,name: any) => {
        const newImage = e.target.files[0];
        if (newImage) {
            setFlashcard({ ...flashcard, [`${name}`]: newImage });
            const reader : any = new FileReader();
            reader.onload = () => {
                setImageData(reader.result); // Cập nhật đường dẫn tạm thời cho hình ảnh
            };
            reader.readAsDataURL(newImage);
        }
    }
    const openNew = () => {
        setSubmitted(false);
        setFlashcard(initialFlashcard);
        setFlashcardDialog(true);
    };

    const hideDialog = () => {
        setFlashcard({ ...flashcard });
        setFlashcardDialog(false);
        setSubmitted(false);
    };

    const hideDeleteExamDialog = () => {
        setDeleteFlashcardDialog(false);
    };

    const confirmDeleteExam = (exam: any) => {
        setFlashcard(exam);
        setDeleteFlashcardDialog(true);
    };

    const updateExam = (exam: any) => {
        setSubmitted(false);
        setFlashcard({ ...exam });
        setFlashcardDialog(true);
    };

    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <Button label="Tạo Từ Vựng" icon="pi pi-plus" className="p-button-success p-mr-2" onClick={openNew} />
            </React.Fragment>
        );
    };

    const actionBodyTemplate = (rowData: any) => {
        return (
            <div className="actions">
                <Button icon="pi pi-pencil" className="p-button-rounded p-button-success p-mr-2"
                    onClick={() => updateExam(rowData)} />
                <Button icon="pi pi-trash" className="p-button-rounded p-button-warning"
                    onClick={() => confirmDeleteExam(rowData)} />
            </div>
        );
    };

    const header = (
        <div className="table-header">
            <h5 className="p-m-0">QUẢN LÝ TỪ VỰNG</h5>
            <span className="p-input-icon-left">
                <i className="pi pi-search" />
                <InputText type="search" onInput={(e: any) => setGlobalFilter(e.target.value)} placeholder="Tìm kiếm..." />
            </span>
        </div>
    );

    const examDialogFooter = (
        <>
            <Button label="Cancel" icon="pi pi-times" className="p-button-text" onClick={hideDialog} />
            <Button label="Save" icon="pi pi-check" className="p-button-text" onClick={saveExam} />
        </>
    );

    const deleteExam = () => {
        const id = flashcard.id;
        let _flashcards = flashcards.filter((value: any) => value.id !== flashcard.id);

        FlashcardApi
            .deleteFlashcard({ id })
            .then(() => {
                // @ts-ignore
                toast.current.show({ severity: "success", summary: "Successful", detail: "Flashcard Deleted", life: 3000 });
            })
            .catch((error) => {
                console.log(error.message);
            });

        setDeleteFlashcardDialog(false);
        setFlashcards(_flashcards);
        setFlashcard(initialFlashcard);
    };
    const deleteExamDialogFooter = (
        <>
            <Button label="No" icon="pi pi-times" className="p-button-text" onClick={hideDeleteExamDialog} />
            <Button label="Yes" icon="pi pi-check" className="p-button-text" onClick={deleteExam} />
        </>
    );


    const totalTimeBody = (rowData: any) => {
        return (
            <>
                <div>{rowData.typewordName}</div>
            </>
        )
    };

    const imageShow = (rowData: any) => {
        return (
            <>
                <div><img src={rowData.image} style={{ width: '50px', height: '50px' }} /></div>
            </>
        )
    };

    return (
        <div className="p-grid crud-demo">
            <div className="p-col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="p-mb-4" left={leftToolbarTemplate} />

                    <DataTable
                        ref={data}
                        value={flashcards}
                        selection={selectedFlashcards}
                        onSelectionChange={(e) => setSelectedFlashcards(e.value)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[5, 10, 25]}
                        className="datatable-responsive"
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        currentPageReportTemplate="Hiển thị {first} đến {last} trong tổng số {totalRecords} đề thi"
                        globalFilter={globalFilter}
                        emptyMessage="Không tìm thấy từ vựng nào."
                        header={header}
                    >
                        <Column selectionMode="multiple" headerStyle={{ width: "3rem" }} />
                        <Column field="word" header="Từ vựng" />
                        <Column field="content" header="Nghĩa" />
                        <Column field="nouns" header="Phát âm" />
                        <Column field="image" header="Ảnh" body={imageShow} />
                        <Column field="typeword" header="Loại Từ" body={totalTimeBody} />
                        <Column field="action" header="Hành Động" body={actionBodyTemplate} />
                    </DataTable>

                    <Dialog visible={flashcardDialog} style={{ width: "450px" }} header="CHI TIẾT ĐỀ THI" modal
                        className="p-fluid" footer={examDialogFooter} onHide={hideDialog}>
                        <div className="p-field">
                            <label htmlFor="word">TỪ VỰNG</label>
                            <InputText id="word" value={flashcard.word}
                                onChange={(e) => onInputChange(e, "word")} required autoFocus
                                className={classNames({ "p-invalid": submitted && !flashcard.word })} />
                            {submitted && !flashcard.word && <small className="p-invalid">Trường thông tin này là bắt buộc</small>}
                        </div>
                        <div className="p-field">
                            <label htmlFor="nouns">PHÁT ÂM</label>
                            <InputText id="nouns" value={flashcard.nouns}
                                onChange={(e) => onInputChange(e, "nouns")} required autoFocus
                                className={classNames({ "p-invalid": submitted && !flashcard.nouns })} />
                            {submitted && !flashcard.nouns && <small className="p-invalid">Trường thông tin này là bắt buộc</small>}
                        </div>
                        <div className="p-field">
                            <label htmlFor="content">NGHĨA</label><br />
                            <InputText id="content" value={flashcard.content} onChange={e => onInputChange(e, 'content')} required autoFocus className={classNames({ "p-invalid": submitted && !flashcard.word })} /> <br />
                            {submitted && !flashcard.content && <small className="p-invalid">Trường thông tin này là bắt buộc</small>}
                        </div>
                        <div className="p-field">
                            <label htmlFor="typeword">LOẠI TỪ</label>
                            <Dropdown id="typeword"
                                value={flashcard.typeword}
                                onChange={(e) => onInputChange(e, "typeword")}
                                options={types} optionLabel="name" optionValue="id"
                                placeholder={"Chọn Loại Từ"}
                                className={classNames({ "p-invalid": submitted && !flashcard.typeword })}
                            />
                            {submitted && !flashcard.typeword && <small className="p-invalid">Trường thông tin này là bắt buộc.</small>}
                        </div>
                        <div className="p-field">
                            <label htmlFor="image">ẢNH</label>
                            <img src={imageData} style={{ width: '100px', height: '100px' }} />
                            <input
                                required
                                type="file"
                                accept="image/*"
                                onChange={e => handleImageChange(e,"image")}
                                className="inputImage"
                            />
                        </div>
                    </Dialog>

                    <Dialog visible={deleteFlashcardDialog} style={{ width: "450px" }} header="Confirm" modal
                        footer={deleteExamDialogFooter} onHide={hideDeleteExamDialog}>
                        <div className="confirmation-content">
                            <i className="pi pi-exclamation-triangle p-mr-3" style={{ fontSize: "2rem" }} />
                            {flashcard && (
                                <span>
                                    Bạn có muốn xóa từ <b>{flashcard.word}</b> ?
                                </span>
                            )}
                        </div>
                    </Dialog>
                </div>
            </div>
        </div>
    );
}

