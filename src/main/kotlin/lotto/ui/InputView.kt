package lotto.ui

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoWinningNumbers
import lotto.domain.ManualLottoCount

class InputView {

    fun readPrice(): Int {
        println(INPUT_PRICE_MESSAGE)
        return readln().toInt()
    }

    fun readManualLottoCount(price: Int): ManualLottoCount {
        println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE)
        val manualLottoCount = readln().toInt()
        return ManualLottoCount(manualLottoCount, price)
    }

    fun readManualLottoNumbers(manualLottoCount: ManualLottoCount): List<LottoNumbers> {
        println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE)
        return List(manualLottoCount.count) {
            val lottoNumbers = readNumbers()
                .map { LottoNumber(it) }
            LottoNumbers.of(lottoNumbers)
        }
    }

    fun readWinningAndBonusNumbers(): LottoWinningNumbers {
        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber()

        return LottoWinningNumbers.of(winningNumbers, bonusNumber)
    }

    private fun readWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        return readNumbers()
    }

    private fun readNumbers(): List<Int> {
        return readln().split(DELIMITER).map { it.trim().toInt() }
    }

    private fun readBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return readln().toInt()
    }

    companion object {
        private const val INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요."
        private const val INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
        private const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
        private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val DELIMITER = ","
    }
}
