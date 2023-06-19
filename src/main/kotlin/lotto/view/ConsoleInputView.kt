package lotto.view

class ConsoleInputView : InputView {
    override fun getPurchaseAmount(): Int {
        print("구입 금액을 입력해 주세요")
        return readln().toInt()
    }

    override fun getWinningNumbers(): List<Int> {
        print("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",")?.map { it.trim().toInt() }!!
    }
}
