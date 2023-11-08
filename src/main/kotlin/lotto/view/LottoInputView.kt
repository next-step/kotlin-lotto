package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.WinningNumbers

object LottoInputView {
    private const val WINNING_NUMBERS_INPUT_DELIMITER = ","

    fun readPurchaseAmountInput(): Long {
        println("구입금액을 입력해 주세요.")
        return readln().toLong()
    }

    fun readWinningNumbersInput(): WinningNumbers {
        println("지난주 당첨 번호를 입력해 주세요.")
        return readln().split(WINNING_NUMBERS_INPUT_DELIMITER)
            .map { LottoNumber(it.trim().toInt()) }
            .let { WinningNumbers(it) }
    }

    fun readBonusNumberInput(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber(readln().toInt())
    }
}
