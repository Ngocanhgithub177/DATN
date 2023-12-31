import React, { useState, useEffect, useRef } from "react";
import { DataTable } from "primereact/datatable";
import { Column } from "primereact/column";
import { Toast } from "primereact/toast";
import { Button } from "primereact/button";
import { Toolbar } from "primereact/toolbar";
import { Dialog } from "primereact/dialog";
import { InputText } from "primereact/inputtext";
import { Dropdown } from "primereact/dropdown";
import { FileUpload } from "primereact/fileupload";
import { Checkbox } from 'primereact/checkbox';

import * as PartApi from "../../../apis/PartApi";
import * as GroupQuestionApi from "../../../apis/GroupQuestionApi";
import * as FileApi from "../../../apis/FileApi";

// @ts-ignore
import { CKEditor } from "@ckeditor/ckeditor5-react";
// @ts-ignore
import ClassicEditor from "@ckeditor/ckeditor5-build-classic";
import classNames from "classnames";

export const GroupQuestion = () => {
    let initialGroupQuestion = {
        id: null,
        numberPart: "",
        title: "",
        groupQuestionDesc: "",
        groupQuestionImg: "",
        audio: "",
        paragraph: "",
    };

    const toast = useRef(null);
    const data = useRef(null);

    const [numberPartItem, setNumberPartItem] = useState(null);
    const [numberPartItems, setNumberPartItems]: any = useState(null);
    const [groupQuestion, setGroupQuestion]: any | null = useState(initialGroupQuestion);
    const [groupQuestions, setGroupQuestions]: any = useState(null);
    const [groupQuestionDialog, setGroupQuestionDialog] = useState(false);
    const [deleteGroupQuestionDialog, setDeleteGroupQuestionDialog] = useState(false);
    const [selectedGroupQuestions, setSelectedGroupQuestions] = useState(null);
    const [globalFilter, setGlobalFilter] = useState(null);
    const [type, setType] = useState('create');
    const [isAudio, setIsAudio] = useState(false);
    const [isImage, setIsImage] = useState(false);
    const [isParagraph, setIsParagraph] = useState(false);
    const [checkedAudio, setCheckedAudio] = useState(false);
    const [checkedImage, setCheckedImage] = useState(false);
    const [checkedParagraph, setCheckedParagraph] = useState(false);
    const [isUpdate, setIsUpdate] = useState(false);
    const [submitted, setSubmitted] = useState(false);

    useEffect(() => {
        const getAllNumberPart = async () => {
            try {
                const response = await PartApi.getAllNumberPart();

                setNumberPartItems(response.data);
            } catch (error) {
                console.log(error.message);
            }
        };

        getAllNumberPart();
    }, []);

    useEffect(() => {
        const getAllGroupQuestions = async () => {
            try {
                const response = await GroupQuestionApi.getAllGroupQuestions();

                setGroupQuestions(response.data);
            } catch (error) {
                console.log(error.message);
            }
        };

        getAllGroupQuestions();
    }, []);

    const openNew = () => {
        setGroupQuestion(initialGroupQuestion);
        setGroupQuestionDialog(true);
        setNumberPartItem(null);
        setType('create');
        setCheckedAudio(false);
        setCheckedImage(false);
        setCheckedParagraph(false);
        setIsAudio(false);
        setIsImage(false);
        setIsParagraph(false);
        setSubmitted(false);
    };

    const hideDialog = () => {
        setGroupQuestionDialog(false);
        setGroupQuestion(initialGroupQuestion);
        setNumberPartItem(null);
        setSubmitted(false);
    };

    const saveGroupQuestion = (e: any) => {
        e.preventDefault();
        setSubmitted(true);

        if (groupQuestion.numberPart && groupQuestion.title.trim()) {
            let _groupQuestions = [...groupQuestions];
            let _groupQuestion = { ...groupQuestion };

            if (groupQuestion.id) {
                const index = findIndexById(groupQuestion.id);
                _groupQuestions[index] = _groupQuestion;

                GroupQuestionApi
                    .updateGroupQuestion(_groupQuestion)
                    .then(() => {
                        // @ts-ignore
                        toast.current.show({
                            severity: "success",
                            summary: "Successful",
                            detail: "Group Question Updated",
                            life: 3000
                        });
                    }).catch((error) => {
                        console.log(error.message);
                    });
            } else {
                GroupQuestionApi
                    .createGroupQuestion(_groupQuestion)
                    .then(() => {
                        // @ts-ignore
                        toast.current.show({
                            severity: "success",
                            summary: "Successful",
                            detail: "Group Question Created",
                            life: 3000
                        });
                    })
                    .catch((error) => {
                        console.log(error.message);
                    });
                _groupQuestions.push(_groupQuestion);
            }

            setGroupQuestionDialog(false);
            setGroupQuestions(_groupQuestions);
            setGroupQuestion(initialGroupQuestion);
            setNumberPartItem(e.value);
        }
    };

    const updateGroupQuestion = (groupQuestion: any) => {
        setGroupQuestion({ ...groupQuestion });
        setGroupQuestionDialog(true);
        setNumberPartItem(null);
        setType('update');
        setIsUpdate(true);
    };

    const deleteGroupQuestion = () => {
        let _groupQuestions = groupQuestions.filter((value: any) => value.id !== groupQuestion.id);
        const id = groupQuestion.id;

        GroupQuestionApi
            .deleteGroupQuestion({ id })
            .then(() => {
                // @ts-ignore
                toast.current.show({
                    severity: "success",
                    summary: "Successful",
                    detail: "Group Question Deleted",
                    life: 3000
                });
            })
            .catch((error) => {
                console.log(error.message);
            });

        setDeleteGroupQuestionDialog(false);
        setGroupQuestions(_groupQuestions);
        setGroupQuestion(initialGroupQuestion);
    };

    const findIndexById = (id: any) => {
        let index = -1;
        for (let i = 0; i < groupQuestions.length; i++) {
            if (groupQuestions[i].id === id) {
                index = i;
                break;
            }
        }

        return index;
    };

    const onInputChange = (e: any, name: any) => {
        setGroupQuestion({ ...groupQuestion, [`${name}`]: (e.target && e.target.value) || "" });
    };

    const onDescriptionChange = (e: any, editor: any, name: any) => {
        setGroupQuestion({ ...groupQuestion, [`${name}`]: editor.getData() || "" });
    };


    const handleUploadFile = (e: any, name: string) => {
        const currentFile = e.files[0];

        FileApi.uploadFile(currentFile).then((res) => {
            setGroupQuestion({ ...groupQuestion, [`${name}`]: res.data.name });
        });
        // @ts-ignore
        toast.current.show({ severity: "success", summary: "Successful", detail: "File Uploaded" });
    };

    const handleNumberPartChange = (e: any, name: any) => {
        setGroupQuestion({ ...groupQuestion, [`${name}`]: e.value.numberPart || "" });
        setNumberPartItem(e.value);
    };

    const confirmDeleteGroupQuestion = (groupQuestion: any) => {
        setGroupQuestion(groupQuestion);
        setDeleteGroupQuestionDialog(true);
    };

    const hideDeleteGroupQuestionDialog = () => {
        setDeleteGroupQuestionDialog(false);
    };

    const handleChooseAudio = (e: any) => {
        if (e.checked) {
            setCheckedAudio(true);
            setIsAudio(true);
        } else {
            setCheckedAudio(false);
            setIsAudio(false);
        }
    }

    const handleChooseImage = (e: any) => {
        if (e.checked) {
            setCheckedImage(true);
            setIsImage(true);
        } else {
            setCheckedImage(false);
            setIsImage(false);
        }
    }

    const handleChooseParagraph = (e: any) => {
        if (e.checked) {
            setCheckedParagraph(true);
            setIsParagraph(true);
        } else {
            setCheckedParagraph(false);
            setIsParagraph(false);
        }
    }

    const leftToolbarTemplate = () => {
        return (
            <React.Fragment>
                <Button label="Tạo nhóm câu hỏi" icon="pi pi-plus" className="p-button-success p-mr-2" onClick={openNew} />
            </React.Fragment>
        );
    };

    const groupQuestionDialogFooter = (
        <>
            <Button label="Hủy bỏ" icon="pi pi-times" className="p-button-text" onClick={hideDialog} />
            <Button label="Lưu" icon="pi pi-check" className="p-button-text" onClick={saveGroupQuestion} />
        </>
    );

    const actionBodyTemplate = (rowData: any) => {
        return (
            <div className="actions">
                <Button icon="pi pi-pencil" className="p-button-rounded p-button-success p-mr-2"
                    onClick={() => updateGroupQuestion(rowData)} />
                <Button icon="pi pi-trash" className="p-button-rounded p-button-warning"
                    onClick={() => confirmDeleteGroupQuestion(rowData)} />
            </div>
        );
    };

    const header = (
        <div className="table-header">
            <h5 className="p-m-0">QUẢN LÝ NHÓM CÂU HỎI</h5>
            <span className="p-input-icon-left">
                <i className="pi pi-search" />
                <InputText type="search" onInput={(e: any) => setGlobalFilter(e.target.value)} placeholder="Tìm kiếm..." />
            </span>
        </div>
    );

    const descriptionBody = (rowData: any) => {
        return (
            <>
                <div dangerouslySetInnerHTML={{ __html: rowData.groupQuestionDesc }} />
            </>
        );
    };

    const paragraphBody = (rowData: any) => {
        return (
            <>
                <div dangerouslySetInnerHTML={{ __html: rowData.paragraph }} />
            </>
        );
    };

    const deleteGroupQuestionDialogFooter = (
        <>
            <Button label="No" icon="pi pi-times" className="p-button-text" onClick={hideDeleteGroupQuestionDialog} />
            <Button label="Yes" icon="pi pi-check" className="p-button-text" onClick={deleteGroupQuestion} />
        </>
    );

    return (
        <div className="p-grid crud-demo">
            <div className="p-col-12">
                <div className="card">
                    <Toast ref={toast} />
                    <Toolbar className="p-mb-4" left={leftToolbarTemplate} />

                    <DataTable
                        ref={data}
                        value={groupQuestions}
                        selection={selectedGroupQuestions}
                        onSelectionChange={(e) => setSelectedGroupQuestions(e.value)}
                        dataKey="id"
                        paginator
                        rows={10}
                        rowsPerPageOptions={[5, 10, 25]}
                        className="datatable-responsive"
                        paginatorTemplate="FirstPageLink PrevPageLink PageLinks NextPageLink LastPageLink CurrentPageReport RowsPerPageDropdown"
                        currentPageReportTemplate="Hiển thị {first} đến {last} trong tổng số {totalRecords} nhóm câu hỏi"
                        globalFilter={globalFilter}
                        emptyMessage="Không tìm thấy nhóm câu hỏi nào."
                        header={header}
                    >
                        <Column selectionMode="multiple" headerStyle={{ width: "3rem" }} />
                        <Column field="numberPart" header="Tên phần thi " />
                        <Column field="title" header="Tiêu Đề" />
                        <Column field="groupQuestionDesc" header="Mô Tả" body={descriptionBody} />
                        <Column field="groupQuestionImg" header="Hình Ảnh" />
                        <Column field="audio" header="Âm thanh/Mp3" />
                        <Column field="paragraph" body={paragraphBody} header="Đoạn Văn" />
                        <Column field="action" header="Hành Động" body={actionBodyTemplate} />
                    </DataTable>

                    <Dialog visible={groupQuestionDialog} style={{ width: "450px" }} header="CHI TIẾT NHÓM CÂU HỎI" modal
                        className="p-fluid" footer={groupQuestionDialogFooter} onHide={hideDialog}>
                        <div className="p-field">
                            <label htmlFor="numberPart">Tên phần thi</label>
                            <Dropdown id="numberPart" disabled={type === 'update'} value={numberPartItem}
                                onChange={(e) => handleNumberPartChange(e, "numberPart")}
                                options={numberPartItems} optionLabel="numberPart"
                                placeholder={isUpdate ? groupQuestion.numberPart : "Chọn một"} autoFocus
                                className={classNames({ "p-invalid": submitted && !groupQuestion.numberPart })} />
                            {submitted && !groupQuestion.numberPart &&
                                <small className="p-invalid" style={{ color: '#f44336' }}>Tên phần thi là bắt buộc.</small>}
                        </div>
                        <div className="p-field">
                            <label htmlFor="title">Tiêu đề</label>
                            <InputText id="title" value={groupQuestion.title}
                                onChange={(e) => onInputChange(e, "title")} required
                                className={classNames({ "p-invalid": submitted && !groupQuestion.title })} />
                            {submitted && !groupQuestion.title &&
                                <small className="p-invalid" style={{ color: '#f44336' }}>Tiêu đề là bắt buộc.</small>}
                        </div>
                        <div className="p-field">
                            <label htmlFor="groupQuestionDesc">Mô tả</label>
                            <CKEditor editor={ClassicEditor} data={groupQuestion.groupQuestionDesc}
                                id="groupQuestionDesc" name="groupQuestionDesc"
                                onChange={(e: any, editor: any) => onDescriptionChange(e, editor, "groupQuestionDesc")} />
                        </div>
                        <div className="p-field">
                            <label htmlFor="groupQuestionMedia">Nhóm câu hỏi</label> <br />
                            <Checkbox checked={checkedAudio} onChange={e => handleChooseAudio(e)} /> Âm thanh <br />
                            <Checkbox checked={checkedImage} onChange={e => handleChooseImage(e)} /> Hình ảnh <br />
                            <Checkbox checked={checkedParagraph} onChange={e => handleChooseParagraph(e)} /> Đoạn văn
                        </div>
                        {isAudio ? <div className="p-field">
                            <label htmlFor="audio">Âm thanh</label>
                            <FileUpload name="audio" multiple accept="audio/*" maxFileSize={250000000} customUpload
                                uploadHandler={(e: any) => handleUploadFile(e, "audio")} />
                        </div> : <></>}
                        {isImage ? <div className="p-field">
                            <label htmlFor="groupQuestionImg">Hình ảnh</label>
                            <FileUpload name="groupQuestionImg" accept="image/*" maxFileSize={250000000} customUpload
                                uploadHandler={(e: any) => handleUploadFile(e, "groupQuestionImg")} />
                        </div> : <></>}
                        {isParagraph ? <div className="p-field">
                            <label htmlFor="paragraph">Đoạn Văn</label>
                            <CKEditor editor={ClassicEditor} id="paragraph" name="paragraph"
                                data={groupQuestion.paragraph}
                                onChange={(e: any, editor: any) => onDescriptionChange(e, editor, "paragraph")} />
                        </div> : <></>}
                    </Dialog>

                    <Dialog visible={deleteGroupQuestionDialog} style={{ width: "450px" }} header="Xác Nhận" modal
                        footer={deleteGroupQuestionDialogFooter} onHide={hideDeleteGroupQuestionDialog}>
                        <div className="confirmation-content">
                            <i className="pi pi-exclamation-triangle p-mr-3" style={{ fontSize: "2rem" }} />
                            {groupQuestion && (
                                <span>
                                    Bạn có chắc muốn xóa <b>{groupQuestion.title}</b> không?
                                </span>
                            )}
                        </div>
                    </Dialog>

                </div>
            </div>
        </div>
    );
};
