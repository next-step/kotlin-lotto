package lotto.view

object InputView {

    private const val LOTTO_BUY_MESSAGE = "구매 금액을 입력해주세요"
    private const val LOTTO_PURCHASES_MESSAGE = "개를 구입 하였습니다."
    private const val LAST_WEEK_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."

    fun inputLottoBuyPrice(): Int {
        println(LOTTO_BUY_MESSAGE)
        return readLine()!!
            .toInt()
    }

    fun lottoPurchasesCount(count: Int) {
        println("$count $LOTTO_PURCHASES_MESSAGE")
    }

    fun lastWeekLottoNumber(): String {
        println(LAST_WEEK_LOTTO_NUMBER_MESSAGE)
        return readLine()!!
    }
}
