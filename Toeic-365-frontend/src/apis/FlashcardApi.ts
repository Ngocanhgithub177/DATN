import * as BaseApi from "./BaseApi";

export const getAll = (): Promise<any> => {
    return BaseApi.getApi("/api/flashcard", {});
}

export const create = ({word,  content,image,nouns,typeword}: any): Promise<any> => {
    return BaseApi.postApi("/api/users/flashcard/create", {word: word, content: content,image:image,nouns:nouns,typeword:typeword});
}

export const update = ({id, word,  content,image,nouns,typeword}: any): Promise<any> => {
    return BaseApi.postApi("/api/users/flashcard/update", {id: id, word: word, content: content,image:image,nouns:nouns,typeword:typeword});
}

export const deleteFlashcard = ({id}: any): Promise<any> => {
    return BaseApi.getApi("/api/flashcard/delete", {id: id});
}

