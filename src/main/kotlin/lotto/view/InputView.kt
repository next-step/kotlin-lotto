package lotto

object InputView {
    fun getPurchaseAmount(): Long {
        println("구입금액을 입력해 주세요.")
        val money = readln().toLong()
        return money
    }
}