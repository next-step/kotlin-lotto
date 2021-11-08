package lotto.view

object InputView {

    const val MONEY_QUESTION = "구입금액을 입력해 주세요."
    const val WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요."
    const val INPUT_NULL_POINTER_EXCEPTION_MESSAGE = "입력은 null일 수 없습니다"
    const val BONUS_BALL_QUESTION = "보너스 볼을 입력해 주세요."

    fun getMoney(): String {
        println(MONEY_QUESTION)
        return readLine() ?: throw IllegalArgumentException(INPUT_NULL_POINTER_EXCEPTION_MESSAGE)
    }

    fun inputWinningNumbers(): String {
        println(WINNING_NUMBER_QUESTION)
        return readLine() ?: throw IllegalArgumentException(INPUT_NULL_POINTER_EXCEPTION_MESSAGE)
    }

    fun inputBonusBall(): String {
        println(BONUS_BALL_QUESTION)
        return readLine() ?: throw IllegalArgumentException(INPUT_NULL_POINTER_EXCEPTION_MESSAGE)
    }
}
