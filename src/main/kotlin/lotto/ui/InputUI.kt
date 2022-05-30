package lotto.ui

object InputUI {

    fun receivePurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return requireNotNull(readLine()).toInt()
    }
}
