package ui.input

class InputView {
    fun enterPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun enterLastWeekWinningNumbers(): List<Int> {
        // 예시 입력: 1, 2, 3, 4, 5, 6
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(", ").map { it.toInt() }
    }
}
