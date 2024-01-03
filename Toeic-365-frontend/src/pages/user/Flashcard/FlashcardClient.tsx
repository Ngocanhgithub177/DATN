import { useEffect, useState } from "react";
import * as FlashcardApi from "../../../apis/FlashcardApi";
import * as TypeWordApi from "../../../apis/TypeWordApi";
import { Button, Table } from "antd";
import NavbarComponent from "../../../components/user/home/navbar.component";
import "./bootstrap.min.scoped.css";
import 'bootstrap/dist/js/bootstrap.js';
import "./navbar.scoped.css";
import 'font-awesome/css/font-awesome.min.css';
import 'bootstrap-icons/font/bootstrap-icons.css'
function FlashcardClient() {

    const [list, setList]: any = useState([]);
    const [temp, setTemp]: any = useState([]);
    const [word, setWord]: any = useState("Từ Vựng");
    const [types, setTypes]: any = useState([]);
    useEffect(() => {
        const getAll = async () => {
            try {
                const response = await FlashcardApi.getAll();
                setList(response.data);
                setTemp(response.data);
            } catch (error: any) {
                console.log(error.message);
            }
        };
        getAll();
    }, []);

    useEffect(() => {
        const getAllTypeWords = async () => {
            try {
                const response = await TypeWordApi.getAll();
                setTypes(response.data);
            } catch (error: any) {
                console.log(error.message);
            }
        };
        getAllTypeWords();
    }, []);

    const columns = [
        {
            title: 'STT',
            render: (value: any, row: any, index: any) => {
                return <div>{index + 1}</div>;
            }
        },
        {
            title: 'Từ Vựng',
            render: (value: any, row: any, index: any) => {
                return (
                    <>
                        <div><img src={value.image} style={{ width: '100px' }} />{value.word}</div>
                    </>
                );
            }
        },
        {
            title: 'Nghĩa',
            dataIndex: 'content',
            key: 'content',
        },
        {
            title: 'Phiên Âm',
            dataIndex: 'nouns',
            key: 'nouns',
        },
        {
            title: 'Loại Từ',
            dataIndex: 'typewordName',
            key: 'typewordName',
        },

    ];

    const changeTypeWord = (e: any,name : any) => {
        if (e !== 0) {
            setList(temp.filter((n: any) => n.typeword === e))
            
        }
        else {
            setList(temp);
        }
        setWord(name);
    }

    return (
        <>
            <NavbarComponent />
            <nav className="navbar navbar-expand-lg navbar-light">
                <div className="collapse navbar-collapse" id="navbarNav">
                    <div className="mr-auto" />
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <Button onClick={() => changeTypeWord(0,'Từ Vựng')} className="nav-link">Tất cả</Button>
                        </li>
                        {
                            types.map((option: any, index: any) => (
                                <li className="nav-item">
                                    <Button onClick={() => changeTypeWord(option.id,option.name)} className="nav-link online-link" >{option.name}</Button>
                                </li>
                            ))
                        }
                    </ul>
                </div>
            </nav>
            <h1 style={{ textAlign: 'center',textTransform:'capitalize'}}>Danh sách {word}</h1>
            <Table dataSource={list} columns={columns} pagination={{ pageSize: 1 }} />
        </>
    );
}
export default FlashcardClient;