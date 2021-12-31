package com.inx.hub.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inx.hub.bean.ApiResult;
import com.inx.hub.callback.Utils;
import com.oracle.javafx.jmx.json.JSONException;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangjinping1000@163.com
 * @Description
 * @Date 12/30/21
 **/

public class ApiResultFunc<T> {
    protected Type type;
    protected Gson gson;

    public ApiResultFunc(Type type) {
        gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.FINAL, Modifier.TRANSIENT, Modifier.STATIC)
                .serializeNulls()
                .create();
        this.type = type;
    }

    public ApiResult<T> apply(String json) throws Exception {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(-1);
        if (type instanceof ParameterizedType) {//自定义ApiResult
            final Class<T> cls = (Class) ((ParameterizedType) type).getRawType();
            if (ApiResult.class.isAssignableFrom(cls)) {
                final Type[] params = ((ParameterizedType) type).getActualTypeArguments();
                final Class clazz = Utils.getClass(params[0], 0);
                final Class rawType = Utils.getClass(type, 0);
                try {

                    //增加是List<String>判断错误的问题
                    if (!List.class.isAssignableFrom(rawType) && clazz.equals(String.class)) {
                        apiResult.setData((T) json);
                        apiResult.setCode(0);
                    } else {
                        ApiResult result = gson.fromJson(json, type);

                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (result != null) {
                            if (result.getData() == null) {
                                if (List.class.isAssignableFrom(rawType)) {
                                    result.setData(new ArrayList());
                                } else {
                                    result.setData(new Object());
                                }
                                result = gson.fromJson(gson.toJson(result), type);

                            }
                            apiResult = result;
                        } else {
                            apiResult.setMsg("json is null ！");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();


                    apiResult.setMsg(e.getMessage());
                } finally {
                }
            } else {
                apiResult.setMsg("ApiResult.class.isAssignableFrom(cls) err!!");
            }
        } else {//默认Apiresult
            try {
                final Class<T> clazz = Utils.getClass(type, 0);
                if (clazz.equals(String.class)) {
                    final ApiResult result = parseApiResult(json, apiResult);
                    if (result != null) {
                        apiResult = result;
                        apiResult.setData((T) json);
                    } else {
                        apiResult.setMsg("json is null！！！");
                    }
                } else {
                    final ApiResult result = parseApiResult(json, apiResult);
                    if (result != null) {
                        apiResult = result;
                        if (apiResult.getData() != null) {
                            T data = gson.fromJson(apiResult.getData().toString(), clazz);
                            apiResult.setData(data);
                        } else {
                            apiResult.setMsg("ApiResult's data is null");
                        }
                    } else {
                        apiResult.setMsg("json is null！！");
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
                apiResult.setMsg(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                apiResult.setMsg(e.getMessage());
            } finally {
            }
        }
        return apiResult;
    }

    private ApiResult parseApiResult(String json, ApiResult apiResult) throws JSONException {
//        if (TextUtils.isEmpty(json))
//            return null;
//        JSONObject jsonObject = new JSONObject(json);
//        if (jsonObject.has("code")) {
//            apiResult.setCode(jsonObject.getInt("code"));
//        }
//        if (jsonObject.has("data")) {
//            apiResult.setData(jsonObject.getString("data"));
//        }
//        if (jsonObject.has("msg")) {
//            apiResult.setMsg(jsonObject.getString("msg"));
//        }
        return apiResult;
    }
}
