package presentation

class InputView {

    companion object {
        fun inputPurchaseAmount(): String {
            println("구입금액을 입력해 주세요.")
            return readln()
        }
    }
}
