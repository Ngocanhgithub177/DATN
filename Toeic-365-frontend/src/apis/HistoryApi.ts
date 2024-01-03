import * as BaseApi from "./BaseApi";

export const getAll = (): Promise<any> => {
    return BaseApi.getApi("/api/history", {});
}

export const create = ({listening_score, reading_score,  timeOfExam,examID}: any): Promise<any> => {
    return BaseApi.postApi("/api/history", {listening_score: listening_score, reading_score: reading_score, timeOfExam: timeOfExam,examID: examID});
}

export const getAllScore = (): Promise<any> => {
    return BaseApi.getApi("/api/score", {});
}