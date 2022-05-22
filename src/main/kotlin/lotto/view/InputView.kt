package lotto.view

import lotto.Const

class InputView {
    fun readPrice(): String {
        printMsg(Const.OutputMsg.GET_PRICE_MSG)
        return readInputAndRequireNotBlank()
    }

    private fun printMsg(message: String) = println(message)

    private fun readInputAndRequireNotBlank(): String {
        val input = readlnOrNull()
        require(!input.isNullOrBlank()) { Const.ErrorMsg.INPUT_VALUE_IS_NULL_ERROR }

        return input
    }
}
