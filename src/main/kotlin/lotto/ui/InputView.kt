package lotto.ui

class InputView {

    fun getPurchasingAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val inputText = readln()
        return parseWinningNumberText(inputText)
    }

    private fun parseWinningNumberText(inputText: String): List<Int> {
        return inputText.split(", ").map { it.toInt() }
    }
}
