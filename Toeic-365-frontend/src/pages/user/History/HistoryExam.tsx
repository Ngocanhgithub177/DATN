import { useEffect, useState } from "react";
import * as HistoryApi from "../../../apis/HistoryApi";
import { Table } from "antd";
function HistoryExam() {

    const [list, setList]: any = useState([]);

    useEffect(() => {
        const getAll = async () => {
            try {
                const response = await HistoryApi.getAll();
                setList(response.data);
            } catch (error: any) {
                console.log(error.message);
            }
        };
        getAll();
    }, []);

    const columns = [
        {
            title: 'STT',
            render: (value : any,row : any, index : any) => {
                return <div>{index + 1}</div>;
              }
        },
        {
            title: 'Exam Name',
            dataIndex: 'examName',
            key: 'examName',
        },
        {
            title: 'Exam Time',
            dataIndex: 'timeOfExam',
            key: 'timeOfExam',
        },
        {
            title: 'Listening',
            dataIndex: 'listening_score',
            key: 'listening_score',
        },
        {
            title: 'Reading',
            dataIndex: 'reading_score',
            key: 'reading_score',
        },
        {
            title: 'Total Score',
            render: (value : any,row : any, index : any) => {
                return <div>{value.listening_score + value.reading_score}</div>;
              }
        },
        
    ];

    return (
        <>
        <h1 style={{textAlign:'center'}}>History Exam </h1>
        <Table dataSource={list} columns={columns} />
        </>
    );
}
export default HistoryExam;