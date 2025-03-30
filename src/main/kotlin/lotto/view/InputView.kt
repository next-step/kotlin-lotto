package lotto.view

class InputView {
    fun getPurchaseAmount(): Int {
        return readln().toInt()
    }

    fun getWinningNumbers(): List<Int> {
        val numbers = readln().split(",")
        return numbers.map { it.trim().toInt() }
    }
}
