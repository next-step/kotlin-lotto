package lotto.view

object InputView {
    fun readPurchaseAmountInput(): Long {
        println("구입금액을 입력해 주세요.")
        return readln().toLong()
    }
}
