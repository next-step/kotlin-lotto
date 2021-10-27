package lotto.views

object InputView {

    fun askWinningLotto(): String {
        println(WINNING_LOTTO_QUESTION)
        return readLine() ?: throw IllegalArgumentException(NULL_NOT_ALLOWED)
    }

    fun askLottoBudget(): Int {
        println(LOTTO_BUDGET_QUESTION)
        return readLine()?.toInt()
            ?: throw IllegalArgumentException(NULL_NOT_ALLOWED)
    }

    fun askBonusNumber(): Int {
        println(BONUS_NUMBER_QUESTION)
        return readLine()?.toInt()
            ?: throw IllegalArgumentException(NULL_NOT_ALLOWED)
    }

    private const val LOTTO_BUDGET_QUESTION = "구입금액을 입력해 주세요."
    private const val WINNING_LOTTO_QUESTION = "지난 주 당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요."
    private const val NULL_NOT_ALLOWED = "입력값은 null을 허용하지 않습니다."
}
