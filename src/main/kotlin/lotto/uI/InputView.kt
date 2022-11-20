package lotto.uI

import lotto.util.ErrorCode

object InputView {
    fun inputMoney(): Long {
        println(MessageCode.INPUT_MONEY.message)
        return requireNotNull(readLine()?.toLongOrNull()) { ErrorCode.MONEY_INPUT_FORMAT_EXCEPTION.errorMessage }
    }
}
