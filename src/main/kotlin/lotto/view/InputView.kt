package lotto.view

import lotto.domain.PurchaseAmount

object InputView {
    fun getPurchaseAmount(): PurchaseAmount {
        println("구입 금액을 입력해 주세요.")
        return PurchaseAmount(readln().toInt())
    }
}
