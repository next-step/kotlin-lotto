package lotto.auto.view

import lotto.auto.port.IOSystem

class InputMoneyView(private val ioSystem: IOSystem) {

    fun getMoney(): Int {
        printInputMessage()
        return inputMoney()
    }

    private fun printInputMessage() = ioSystem.write("구입 금액을 입력해 주세요.\n")

    private fun inputMoney(): Int = ioSystem.read().toInt()
}
