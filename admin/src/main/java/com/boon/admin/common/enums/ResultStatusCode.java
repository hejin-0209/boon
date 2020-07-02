package com.boon.admin.common.enums;


/**
 * @param
 * @description 自定义状态码
 * @return
 */
public enum ResultStatusCode {
    OK(200, "操作成功"),
    SIGN_ERROR(120, "签名错误"),
    TIME_OUT(130, "访问超时"),
    BAD_REQUEST(400, "参数解析失败"),
    INVALID_TOKEN(401, "无效的授权码"),
    INVALID_CLIENTID(402, "无效的密钥"),
    METHOD_NOT_ALLOWED(405, "不支持当前请求方法"),
    SYSTEM_ERR(500, "服务器运行异常"),
    NOT_EXIST_USER_OR_ERROR_PWD(10000, "该用户不存在或密码错误"),
    LOGINED_IN(10001, "该用户已登录"),
    SHIRO_ERROR(10003, "登录异常"),
    UNAUTHO_ERROR(10004, "您没有该权限"),
    UNLOGIN_ERROR(10005,"未登录"),
    UPLOAD_ERROR(20000, "上传文件异常"),
    INVALID_CAPTCHA(30005, "无效的验证码"),
    USER_FROZEN(40000, "该用户已被冻结，请联系管理员！"),
    USER_NOT_EXIST(40001,"此用户不存在，请您先去添加此用户！"),
    ROLENAME_EXIST(40003,"角色名已经被使用，请您重新定义一个角色名！"),
    ROlE_EXIST(40002,"角色已在使用，请您先解除用户权限关系后再重试");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private ResultStatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
