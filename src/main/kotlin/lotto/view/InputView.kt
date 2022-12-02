package lotto.view

object InputView {

    private const val LOTTO_BALL_DELIMITER = ","
    fun askLottoBuyMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun askWinningLottoBall(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return askLottoNumber()
    }

    fun askBonusBall(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    fun askManualLottoBuyNumber(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun askManualLotto(manualLottoBuyNumber: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..manualLottoBuyNumber).map {
            askLottoNumber()
        }
    }
    private fun askLottoNumber(): List<Int> {
        return readln().split(LOTTO_BALL_DELIMITER).map { it.trim().toInt() }
    }
}
