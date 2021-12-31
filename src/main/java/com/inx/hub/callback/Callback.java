package com.inx.hub.callback;

import java.lang.reflect.Type;

/**
 * @Author huangjinping1000@163.com
 * @Description
 * @Date 12/15/21
 **/


public abstract class Callback<T> {

    public abstract void onResponse(T response, int id);

    public abstract T parseNetworkResponse(String json, int id);

    public Type getType() {//获取需要解析的泛型T类型
        return Utils.findNeedClass(getClass());
    }

    public Type getRawType() {//获取需要解析的泛型T raw类型
        return Utils.findRawType(getClass());
    }

}