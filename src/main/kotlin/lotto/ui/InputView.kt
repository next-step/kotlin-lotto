package lotto.ui

import lotto.constant.Message

object InputView {
    fun getPurchaseAmount(): String {
        println(Message.INPUT_PURCHASE_AMOUNT)
        return readLine()!!
    }

    fun getWinningNumber(): String {
        println(Message.INPUT_WINNING_NUMBER)
        return readLine()!!
    }
}
