package lotto.ui

object InputView {
    fun receiveNumbers(): Int {
        println("구입금액을 입력해 주세요.")
        val money = readln().toInt()
        return money
    }

    fun receiveWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = readln()
        return winningNumbers.split(", ")
            .toList()
            .map { it.toInt() }
    }
}
