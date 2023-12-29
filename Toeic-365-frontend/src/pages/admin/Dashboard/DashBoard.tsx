import React, { useEffect, useState } from 'react';
import { Calendar } from 'primereact/calendar';
import { Card, Col, Row } from 'antd';
import Meta from 'antd/lib/card/Meta';
import * as StatisticsApi from "../../../apis/StatisticsApi";
export const DashBoard = () => {
    const [statistics, setStatistics] = useState<any>('');
    useEffect(() => {
        const getData = async () => {
            try {
                const response = await StatisticsApi.getData();

                setStatistics(response.data);
            } catch (error) {
                console.log(error.message);
            }
        };

        getData();
    }, []);
    return (
        <>
            <Row gutter={[8, 16]}>
                <Col span={6} >
                    <Card
                        hoverable
                        style={{ width: 360 }}
                        cover={<img alt="example" style={{height: 400}} src="https://png.pngtree.com/png-vector/20190805/ourlarge/pngtree-account-avatar-user-abstract-circle-background-flat-color-icon-png-image_1650938.jpg" />}
                    >
                        <Meta title="Số Lượng Tài Khoản" description={statistics ? statistics?.numberAccounts : ''} />
                    </Card>
                </Col>
                <Col span={6} >
                    <Card
                        hoverable
                        style={{ width: 360 }}
                        cover={<img alt="example" src="https://cdn3.iconfinder.com/data/icons/cosmo-color-user/40/registered_user-512.png" style={{height: 400}} />}
                    >
                        <Meta title="Số Lượng Tài Khoản đã làm bài test" description={statistics ? statistics?.numberRegisteredAccounts : ''} />
                    </Card>
                </Col>
                <Col span={6} >
                    <Card
                        hoverable
                        style={{ width: 360 }}
                        cover={<img alt="example" src="https://tutoria.pk/blog/wp-content/uploads/2021/07/gh.jpg" style={{height: 400}} />}
                    >
                        <Meta title="Số Lượng Đề Thi" description={statistics ? statistics?.numberExam : ''} />
                    </Card>
                </Col>
                <Col span={6} >
                    <Card
                        hoverable
                        style={{ width: 360 }}
                        cover={<img alt="example" src="https://d2nklej7l2bs3q.cloudfront.net/wp-content/uploads/2021/11/exam-preparation.jpg" style={{height: 400}} />}
                    >
                        <Meta title="Số Lượng Câu Hỏi" description={statistics ? statistics?.numberQuestion : ''} />
                    </Card>
                </Col>
            </Row>
        </>
    );
}

