package lotto.application.console

class InputView {

    fun inputCost(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(NUMBER_DELIMITER).map { it.trim().toInt() }
    }

    companion object {
        private const val NUMBER_DELIMITER = ","
    }
}
