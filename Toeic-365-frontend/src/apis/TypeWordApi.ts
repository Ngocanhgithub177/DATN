import * as BaseApi from "./BaseApi";

export const getAll = (): Promise<any> => {
    return BaseApi.getApi("/api/typeword", {});
}


