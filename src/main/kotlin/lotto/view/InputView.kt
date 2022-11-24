package lotto.view

import lotto.domain.PurchaseAmount
import lotto.domain.WinningNumbers

object InputView {
    fun getPurchaseAmount(): PurchaseAmount {
        println("구입 금액을 입력해 주세요.")
        return PurchaseAmount.from(readln())
    }

    fun getWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return WinningNumbers.from(readln())
    }
}
