package lotto.view

object InputView {
    private const val BUYING_COMMNET = "구입금액을 입력해 주세요."
    private const val LAST_WEEK_WINNING_LOTTO_NUMBERS_COMMENT = "지난 주 당첨 번호를 입력해 주세요."

    fun enterLottoBuyingPrice(): Int {
        println(BUYING_COMMNET)
        return readLine()?.toInt() ?: throw IllegalArgumentException()
    }

    fun enterLastWeekWinningLottoNumbers(): String {
        println(LAST_WEEK_WINNING_LOTTO_NUMBERS_COMMENT)
        return readLine() ?: throw IllegalArgumentException()
    }
}
