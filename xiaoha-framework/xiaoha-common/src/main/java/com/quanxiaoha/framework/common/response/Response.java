package com.quanxiaoha.framework.common.response;

import com.quanxiaoha.framework.common.exception.BaseExceptionInterface;
import com.quanxiaoha.framework.common.exception.BizException;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {

    // 是否成功，默认为 true
    private boolean success = true;
    // 响应消息
    private String message;
    // 异常码
    private String errorCode;
    // 响应数据
    private T data;

    /**
     * 成功响应
     * @return
     * @param <T>
     */
    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        return response;
    }

    /**
     * 成功响应
     * @param data 响应的数据
     * @return
     * @param <T>
     */
    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    /**
     * 响应失败
     * @return
     * @param <T>
     */
    public static <T> Response<T> fail() {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        return response;
    }

    /**
     * 响应失败
     * @param errorMessage 错误信息
     * @return
     * @param <T>
     */
    public static <T> Response<T> fail(String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(errorMessage);
        return response;
    }

    /**
     * 响应失败
     * @param errorCode 错误码
     * @param errorMessage 错误信息
     * @return
     * @param <T>
     */
    public static <T> Response<T> fail(String errorCode, String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(errorCode);
        response.setMessage(errorMessage);
        return response;
    }

    /**
     * 响应失败
     * @param bizException 业务异常
     * @return
     * @param <T>
     */
    public static <T> Response<T> fail(BizException bizException) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(bizException.getErrorCode());
        response.setMessage(bizException.getErrorMessage());
        return response;
    }

    /**
     * 响应失败
     * @param baseExceptionInterface 基础异常接口
     * @return
     * @param <T>
     */
    public static <T> Response<T> fail(BaseExceptionInterface baseExceptionInterface) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setErrorCode(baseExceptionInterface.getErrorCode());
        response.setMessage(baseExceptionInterface.getErrorMessage());
        return response;
    }

}
