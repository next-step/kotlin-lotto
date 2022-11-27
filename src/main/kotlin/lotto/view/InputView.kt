package lotto.view

import lotto.domain.PurchaseAmount
import lotto.domain.WinningLottoNumbers

object InputView {
    fun getPurchaseAmount(): PurchaseAmount {
        println("구입 금액을 입력해 주세요.")
        return PurchaseAmount(readln().toInt())
    }

    fun getWinningNumbers(): WinningLottoNumbers {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return WinningLottoNumbers.from(readln())
    }
}
