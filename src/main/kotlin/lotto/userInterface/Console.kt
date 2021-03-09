package lotto.userInterface

class Console : UserInterface {
    override fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toInt() ?: 0
    }
}
