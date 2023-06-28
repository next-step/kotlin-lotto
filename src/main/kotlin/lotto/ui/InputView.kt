package lotto.ui

import lotto.domain.LottoMatchNumbers

object InputView {

    private const val INPUT_MATCHING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
    private const val DELIMITER = ","

    fun readNumbers(): LottoMatchNumbers {
        val matchingNumbers = readMatchingNumbers()
        val bonusNumber = readBonusNumber()

        return LottoMatchNumbers.of(matchingNumbers, bonusNumber)
    }

    fun readPrice(): Int {
        println(INPUT_PRICE_MESSAGE)
        return readln().toInt()
    }

    private fun readMatchingNumbers(): List<Int> {
        println(INPUT_MATCHING_NUMBER_MESSAGE)
        return readln().split(DELIMITER).map { it.trim().toInt() }
    }

    private fun readBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        return readln().toInt()
    }
}
