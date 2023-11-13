package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoList
import lotto.domain.LottoNumber
import lotto.domain.ManualLottoCreator
import lotto.domain.Money
import lotto.domain.WinningNumbers

object InputView {
    fun getPurchaseAmount(): Money {
        println("구입금액을 입력해 주세요.")
        val money = IntInput(readln()).input
        return Money(money)
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return IntInput(readln()).input
    }

    fun getManualLottoNumbers(count: Int): LottoList {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val list = mutableListOf<Lotto>()
        repeat(count) {
            val numbers = ManualLottoCreator(LottoNumbersInput(readln()).numbers).createLotto()
            list.add(numbers)
        }
        return LottoList(list)
    }

    fun getWinningNumbers(): WinningNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val winningNumbers = LottoNumbersInput(readln()).numbers
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber(IntInput(readln()).input)

        return WinningNumbers(winningNumbers, bonusNumber)
    }
}
