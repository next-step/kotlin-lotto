package lotto.ui

class InputView {
    fun getPurchaseAmount(): String {
        println("구입금액을 입력해 주세요.")
        return readln()
    }
}
