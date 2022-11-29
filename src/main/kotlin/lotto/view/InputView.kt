package lotto.view

object InputView {

    private const val LOTTO_BALL_DELIMITER = ","
    fun askLottoBuyMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun askWinningLottoBall(): List<String> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(LOTTO_BALL_DELIMITER)
    }

    fun askBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }
}
