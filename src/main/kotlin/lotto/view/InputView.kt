package lotto.view

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.WinningLotto

class InputView {
    fun inputPurchasePrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputLastWeekWinningLotto(): WinningLotto {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readln().split(NUMBERS_DELIMITER).map { it.toInt() }
        val lottoNumbers = numbers.map { LottoNumber.create(it) }
        val bonusNumber = inputBonusNumber()
        return WinningLotto(Lotto(lottoNumbers), bonusNumber)
    }

    private fun inputBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber.create(readln().toInt())
    }

    companion object {
        private const val NUMBERS_DELIMITER: String = ", "
    }
}
