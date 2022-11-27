package lotto.view


object InputView {

    private const val LOTTO_BALL_DELIMITER = ","
    fun askLottoBuyMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun askWinningLottoBall(): List<String> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.split(LOTTO_BALL_DELIMITER)
    }

}
