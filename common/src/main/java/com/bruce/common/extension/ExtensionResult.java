package com.bruce.common.extension;

import lombok.Getter;

/**
 * 扩展执行结果
 * <p>
 * 操作结果将直接影响处理流程：<br>
 * 1. 事务域内失败时，无论是否发生致命错误都将回滚<br>
 * 2. 非事务域失败时，仅在致命错误时终止流程，否则以warn日志形式继续执行
 * </p>
 *
 * @author lql
 * @date 2021/9/26 5:12 下午
 */
@Getter
public class ExtensionResult {

    private static final String INTERNAL_CODE = "EXTENSION_INTERNAL";
    private static final ExtensionResult SUCCESS_RESULT = new ExtensionResult(true, false, null);
    private static final ExtensionResult INTERNAL_RESULT = new ExtensionResult(true, true, INTERNAL_CODE);

    /**
     * 操作是否成功<br>
     * <p>
     * 操作结果将直接影响处理流程：<br>
     * 1. 事务域内失败时，无论是否发生致命错误都将回滚<br>
     * 2. 非事务域失败时，仅在致命错误时终止流程，否则以warn日志形式继续执行
     * </p>
     */
    private boolean success;

    /**
     * 错误是否致命<br>
     *
     * @see #success
     */
    private boolean deadly;

    /**
     * 错误消息
     */
    private String message;

    /**
     * 是否为内部定义结果
     *
     * @return 是否内部定义结果
     */
    boolean isInternal() {
        return INTERNAL_RESULT.equals(this);
    }

    /**
     * 全参构造函数
     *
     * @param success 执行是否成功
     * @param deadly  是否为致命错误
     * @param message 错误消息
     */
    private ExtensionResult(boolean success, boolean deadly, String message) {
        this.success = success;
        this.deadly = deadly;
        this.message = message;
    }

    /**
     * 执行结果正常
     *
     * @return 固定ok对象
     */
    public static ExtensionResult ok() {
        return SUCCESS_RESULT;
    }

    /**
     * 执行失败
     *
     * @param deadly  是否为致命错误
     * @param message 错误消息
     * @return 失败对象
     */
    public static ExtensionResult fail(boolean deadly, String message) {
        return new ExtensionResult(false, deadly, message);
    }

    /**
     * 内部使用
     * <p>
     * 对于定义的扩展接口默认实现，考虑到兼容性问题，其默认实现需要返回此方法结果。<br>
     * 在数据检查时，若发现为内部定义对象，直接结束处理。逻辑参见{@link AbstractExtensionDeal#digestion(ExtensionResult)}
     *
     * </p>
     *
     * @return 内部定义对象
     */
    public static ExtensionResult internal() {
        return SUCCESS_RESULT;
    }
}
