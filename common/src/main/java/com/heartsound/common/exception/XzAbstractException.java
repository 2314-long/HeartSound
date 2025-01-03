package com.heartsound.common.exception;


import com.heartsound.common.utils.IRCode;

/**
 * 异常抽象类
 *
 * @author sl
 */
public abstract class XzAbstractException extends RuntimeException {

    /**
     * 响应码
     */
    private final String code;

    /**
     * 自定义响应码和响应信息
     *
     * @param code 响应码
     * @param msg  响应信息
     */
    public XzAbstractException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    /**
     * 直接返回响应码枚举
     */
    public XzAbstractException(IRCode irCode) {
        super(irCode.getMsg());
        this.code = irCode.getCode();
    }

    public String getCode() {
        return code;
    }

}
