package com.nextstep.jngcii.lotto.view

object InputView {
    private const val LOTTO_PRICE = 1_000

    fun getCount(input: String?): Int {
        val pay = input
            ?.toIntOrThrow()
            ?.validatePositiveOrThrow()
            ?: return 0

        return pay.getQuotient(LOTTO_PRICE)
    }

    private fun String.toIntOrThrow(): Int {
        try {
            return this.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("정수만 입력 가능합니다.")
        }
    }

    private fun Int.validatePositiveOrThrow(): Int {
        require(this >= 0) { "" }
        return this
    }

    private fun Int.getQuotient(operand: Int) = this / operand
}
