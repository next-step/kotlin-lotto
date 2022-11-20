package lotto.view

import lotto.util.StringValidator

class InputView {

    fun inputPayment(): Int {
        println(INPUT_PAYMENT_GUIDE)
        val payment = readln()
        validatePaymentInput(payment)
        return payment.toInt()
    }

    private fun validatePaymentInput(payment: String) {
        StringValidator.validateNotBlank(payment)
        StringValidator.validateNumber(payment)
    }

    fun inputLuckyNumbers(): List<Int> {
        println(INPUT_LUCKY_NUMBERS_GUIDE)
        val luckyNumberString = readln()
        val luckyNumbers = splitNumbers(luckyNumberString)
        validateLuckyNumbersInput(luckyNumbers)
        return convert(luckyNumbers)
    }

    private fun splitNumbers(input: String) = input.split(",").map { it.trim() }

    private fun validateLuckyNumbersInput(split: List<String>) {
        split.forEach {
            StringValidator.validateNotBlank(it)
            StringValidator.validateNumber(it)
        }
    }

    private fun convert(split: List<String>): List<Int> {
        return split.map { it.toInt() }
    }

    private companion object {
        const val INPUT_PAYMENT_GUIDE = "# 구입금액을 입력해주세요."
        const val INPUT_LUCKY_NUMBERS_GUIDE = "# 지난 주 당첨 번호를 입력해 주세요."
    }
}
