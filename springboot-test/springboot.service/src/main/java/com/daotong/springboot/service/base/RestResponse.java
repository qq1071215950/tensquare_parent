package com.daotong.springboot.service.base;

/**
 * @author 陈井彬
 * @date 2019/07/13
 */
public class RestResponse<T> {

    /**
     * 业务处理是否成功的标记<p> true|false</p>
     */
    private boolean success;

    /**
     * 错误码<p>'no_permission'</p>
     */
    private String code;

    /**
     * 错误信息<p>'这是错误信息!'</p>
     */
    private String message;

    /**
     * 数据字段, 用于表达前端需要的数据<p> list|single</p>
     */
    private T data;

    /**
     * 成功
     */
    public RestResponse() {
        this.success = true;
        this.message = "操作成功";
    }

    /**
     * 成功
     *
     * @param data 待返回的数据
     */
    public RestResponse(T data) {
        this.success = true;
        this.data = data;
    }

    /**
     * 失败
     *
     * @param code 错误码
     * @param errMsg 错误描述
     */
    public RestResponse(String code, String errMsg) {
        this.success = false;
        this.code = code;
        this.message = errMsg;
    }

    /**
     * data字段留空
     *
     * @return RestResponse
     */
    public static RestResponse empty() {
        return new RestResponse();
    }

    /**
     * 返回报错信息
     *
     * @param code 错误码
     * @param errMsg 错误描述
     * @return RestResponse
     */
    public static RestResponse error(String code, String errMsg) {
        return new RestResponse(code, errMsg);
    }

    /**
     * 返回对象
     *
     * @param data 待返回的数据
     * @return RestResponse
     */
    public static <S> RestResponse<S> single(S data) {
        return new RestResponse<S>(data);
    }

    /**
     * 返回成功标识
     *
     * @return RestResponse
     */
    public static RestResponse success() {
        return new RestResponse();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
