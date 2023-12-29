import * as BaseApi from "./BaseApi";

export const getData = (): Promise<any> => {
    return BaseApi.getApi("/api/statistics", {});
}