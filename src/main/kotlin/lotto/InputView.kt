package lotto

class InputView(private val input: Input) {
    fun askPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return input.readPurchaseAmount()
    }

    fun askLastWeekWinningNumber(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return input.readLastWeekWinningNumbers()
    }
}
