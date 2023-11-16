package lotto.view

import lotto.domain.LottoBuyStrategy
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.Money
import lotto.domain.WinningNumbers

object InputView {
    fun getPurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        val money = IntInput(readln()).input
        return Money(money)
    }

    fun getBuyStrategy(money: Money): LottoBuyStrategy {
        return LottoBuyStrategy(money, getManualLottoNumbers())
    }

    private fun getManualLottoNumbers(): List<LottoNumbers> {
        val count = getManualLottoCount()

        println("수동으로 구매할 번호를 입력해 주세요.")
        val list = mutableListOf<LottoNumbers>()
        repeat(count) {
            val numbers = LottoNumbersInput(readln()).numbers
            list.add(numbers)
        }
        return list
    }

    private fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return IntInput(readln()).input
    }

    fun getWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = LottoNumbersInput(readln()).numbers
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber(IntInput(readln()).input)

        return WinningNumbers(winningNumbers, bonusNumber)
    }
}
