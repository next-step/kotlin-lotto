package lotto.view

object InputView {
    private const val ASK_LOTTO_BUY_MONEY = "구입금액을 입력해주세요."
    private const val ASK_WINNING_LOTTO_NUMBERS = "지난주 당첨 번호를 입력해주세요."

    fun askLottoMoney(): Int {
        println(ASK_LOTTO_BUY_MONEY)
        return readln().toInt()
    }

    fun askWinningLottoNumbers(): List<Int> {
        println(ASK_WINNING_LOTTO_NUMBERS)
        return readln().split(",").map { it.trim().toInt() }
    }
}
