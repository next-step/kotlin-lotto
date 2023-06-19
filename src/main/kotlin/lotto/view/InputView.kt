package lotto.view

object InputView {

    private const val DELIMITER = ","

    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLottoWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(DELIMITER).map { it.toInt() }
    }
}
