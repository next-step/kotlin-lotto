package lotto.view

object InputView {
    private const val TOTAL_PAYMENT_QUESTION = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_BALL_NUMBER_QUESTION = "보너스 볼을 입력해 주세요."

    fun readTotalPayment(): Int {
        println(TOTAL_PAYMENT_QUESTION)

        return readln()
            .getPositiveNumber()
            ?: throw IllegalArgumentException("구입금액은 0 이상의 정수이여야 합니다")
    }

    fun readWinningNumbers(): List<Int> {
        println("\n$WINNING_NUMBERS_QUESTION")

        return readln()
            .split(",")
            .map { numberString ->
                numberString.trim()
                    .getPositiveNumber()
                    ?: throw IllegalArgumentException("당첨 번호는 0 이상의 정수이여야 합니다")
            }
    }

    fun readBonusBallNumber(): Int {
        println(BONUS_BALL_NUMBER_QUESTION)

        return readln()
            .getPositiveNumber()
            ?: throw IllegalArgumentException("보너스 볼 번호는 0 이상의 정수이여야 합니다")
    }

    private fun String.getPositiveNumber(): Int? = toIntOrNull()?.takeIf { it >= 0 }
}
