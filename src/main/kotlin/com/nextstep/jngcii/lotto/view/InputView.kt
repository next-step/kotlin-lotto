package com.nextstep.jngcii.lotto.view

object InputView {
    private const val LOTTO_PRICE = 1_000

    fun getCount(read: () -> String?): Int {
        println("구입금액을 입력해 주세요.")

        val pay = read()
            ?.toIntOrThrow()
            ?.validatePositiveOrThrow()
            ?: return 0

        return pay.getQuotient(LOTTO_PRICE)
    }

    fun getNumbers(read: () -> String?): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val input = read()
        require(!input.isNullOrBlank()) { "입력값이 없습니다" }
        return input
            .split(",")
            .map { it.trim().toIntOrThrow() }
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
