package lotto.view

class InputView {
    fun inputPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        return readln()
    }

    fun inputWinningNumbers(): String {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }
}
