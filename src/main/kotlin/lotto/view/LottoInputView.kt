package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.WinningNumbers
import lotto.domain.Won

object LottoInputView {
    private const val MANUAL_LOTTO_NUMBERS_INPUT_DELIMITER = ","
    private const val WINNING_NUMBERS_INPUT_DELIMITER = ","

    fun readPurchaseAmountInput(): Won {
        println("구입금액을 입력해 주세요.")
        return Won(readln().toLong())
    }

    fun readManualLottoCountInput(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun readManualLottoNumbersInput(manualLottoCount: Int): List<List<LottoNumber>> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        return List(manualLottoCount) {
            readln().split(MANUAL_LOTTO_NUMBERS_INPUT_DELIMITER)
                .map { LottoNumber(it.trim().toInt()) }
        }
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
