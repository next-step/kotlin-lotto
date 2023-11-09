package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.Money
import lotto.domain.WinningNumbers

object InputView {
    fun getPurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        val money = IntInput(readln()).input
        return Money(money)
    }

    fun getWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = LottoNumbersInput(readln()).numbers
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber(IntInput(readln()).input)

        return WinningNumbers(winningNumbers, bonusNumber)
    }
}
