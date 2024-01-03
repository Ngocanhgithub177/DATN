import * as BaseApi from "./BaseApi";

export const getAll = (): Promise<any> => {
    return BaseApi.getApi("/api/flashcard", {});
}

export const create = (formData: any): Promise<any> => {
    return BaseApi.postApiMultipart("/api/flashcard/create", formData);
}

export const update = ({id, word,  content,image,nouns,typeword}: any): Promise<any> => {
    return BaseApi.postApiMultipart("/api/flashcard/update", {id: id, word: word, content: content,image:image,nouns:nouns,typeword:typeword});
}

export const deleteFlashcard = ({id}: any): Promise<any> => {
    return BaseApi.getApi("/api/flashcard/delete", {id: id});
}

