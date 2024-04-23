package com.inx.hub.callback;

import com.inx.hub.bean.ApiResult;
import com.inx.hub.json.ApiResultFunc;
import com.inx.hub.json.CallBackProxy;



public abstract class SimpleCallBack<T> extends Callback<T> {

    @Override
    public T parseNetworkResponse(String json, int id) {
        ApiResult<T> apiResult = new ApiResult();
        CallBackProxy<ApiResult<T>, T> proxy = new CallBackProxy<ApiResult<T>, T>(this) {
        };
        ApiResultFunc<T> apiResultFunc = new ApiResultFunc(proxy.getType());
        try {
            apiResult = apiResultFunc.apply(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiResult.getData();
    }


}
