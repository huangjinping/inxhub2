/*
 * Copyright (C) 2017 zhouyou(478319399@qq.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.inx.hub.json;

import com.google.gson.internal.$Gson$Types;
import com.inx.hub.bean.ApiResult;
import com.inx.hub.callback.Callback;
import com.inx.hub.callback.Utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


/**
 * <p>描述：提供回调代理</p>
 * 主要用于可以自定义ApiResult<br>
 * 作者： zhouyou<br>
 * 日期： 2017/5/16 17:59 <br>
 * 版本： v1.0<br>
 */
public abstract class CallBackProxy<T extends ApiResult<R>, R> implements IType<T> {
    Callback<R> mCallBack;

    public CallBackProxy(Callback<R> callBack) {
        mCallBack = callBack;
    }

    public Callback getCallBack() {
        return mCallBack;
    }

    @Override
    public Type getType() {//CallBack代理方式，获取需要解析的Type
        Type typeArguments = null;
        if (mCallBack != null) {
            Type rawType = mCallBack.getRawType();//如果用户的信息是返回List需单独处理
            if (List.class.isAssignableFrom(Utils.getClass(rawType, 0)) || Map.class.isAssignableFrom(Utils.getClass(rawType, 0))) {
                typeArguments = mCallBack.getType();
            } else {
                Type type = mCallBack.getType();
                typeArguments = Utils.getClass(type, 0);
            }
        }

        Type rawType = Utils.findNeedType(getClass());
        if (rawType instanceof ParameterizedType) {
            rawType = ((ParameterizedType) rawType).getRawType();
        }
        return $Gson$Types.newParameterizedTypeWithOwner(null, rawType, typeArguments);
    }
}
