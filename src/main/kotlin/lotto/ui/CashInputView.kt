package lotto.ui

import lotto.data.BuyingData

object CashInputView {

    fun askPurchasePrice(): Int {
        println("구매금액을 입력해주세요.")
        val purchasePrice = readLine()
        return purchasePrice?.toIntOrNull() ?: throw IllegalArgumentException("잘못된 입력값이 들어왔습니다.($purchasePrice)")
    }
}
