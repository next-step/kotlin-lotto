package lotto.view

object InputView {
    fun purchaseAmountInput(): Int {
        println("구입금액을 입력해 주세요,")

        return readln().toInt()
    }

    fun winningNumberInput(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningNumber = readln()
        require(winningNumber.isNotEmpty()) {
            "당첨 번호를 입력해주세요."
        }

        return printSplitWinningNumber(winningNumber)
    }

    private fun printSplitWinningNumber(number: String): Set<Int> {
        return number
            .split(", ")
            .map { it.toInt() }
            .toSet()
    }
}
