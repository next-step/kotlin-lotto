package lotto.view

object InputView {
    private const val TOTAL_PAYMENT_QUESTION = "구입금액을 입력해 주세요."

    fun readTotalPayment(): Int {
        println(TOTAL_PAYMENT_QUESTION)

        return readln()
            .getPositiveNumber()
            ?: throw IllegalArgumentException("구입금액은 0 이상의 정수이여야 합니다")
    }

    private fun String.getPositiveNumber(): Int? = toIntOrNull()?.takeIf { it >= 0 }
}
