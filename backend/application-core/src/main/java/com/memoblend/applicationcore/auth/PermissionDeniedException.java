package com.memoblend.applicationcore.auth;

import com.memoblend.applicationcore.constant.ExceptionIdConstants;
import com.memoblend.systemcommon.exception.LogicException;

/**
 * 認可が拒否された場合の例外です。
 */
public class PermissionDeniedException extends LogicException {

    /**
     * 実行を試みた操作を指定して、
     * {@link PermissionDeniedException} クラスの新しいインスタンスを初期化します。
     * 
     * @param operationName 実行を試みた操作。
     */
    public PermissionDeniedException(String operationName) {
        super(null, ExceptionIdConstants.E_PERMISSION_DENIED, new String[] { String.valueOf(operationName) },
                new String[] { String.valueOf(operationName) });
    }
}
