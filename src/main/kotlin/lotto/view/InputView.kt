package lotto.view

object InputView {

    private const val LOTTO_BUY_MESSAGE = "구매 금액을 입력해주세요"
    private const val LAST_WEEK_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val LAST_WEEK_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요."
    private const val DEFAULT_WINNING_LOTTO_NUMBER = "1,2,3,4,5,6"

    fun inputLottoBuyPrice(): Int {
        println(LOTTO_BUY_MESSAGE)
        return readLine()?.toInt() ?: 0
    }

    fun lastWeekLottoNumber(): String {
        println(LAST_WEEK_LOTTO_NUMBER_MESSAGE)
        return readLine() ?: DEFAULT_WINNING_LOTTO_NUMBER
    }

    fun lastWeekBonusNumber(): Int {
        println(LAST_WEEK_LOTTO_BONUS_NUMBER_MESSAGE)
        return readLine()?.toInt() ?: 0
    }
}
