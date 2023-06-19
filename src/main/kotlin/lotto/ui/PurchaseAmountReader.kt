package lotto.ui

object PurchaseAmountReader {

    fun read(): Int {
        println("구매금액을 입력해 주세요.")
        val purchaseFee = readln()
        return purchaseFee.toInt()
    }
}
