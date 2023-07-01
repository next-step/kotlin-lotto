package lotto.ui

import lotto.domain.LottoWinningNumbers

class InputView {

    fun readWinningAndBonusNumbers(): LottoWinningNumbers {
        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber()

        return LottoWinningNumbers.of(winningNumbers, bonusNumber)
    }

    fun readPrice(): Int {
        println(INPUT_PRICE_MESSAGE)
        return readln().toInt()
    }

    private fun readWinningNumbers(): List<Int> {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        return readln().split(DELIMITER).map { it.trim().toInt() }
    }

    private fun readBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return readln().toInt()
    }

    companion object {
        private const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
        private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val DELIMITER = ","
    }
}
