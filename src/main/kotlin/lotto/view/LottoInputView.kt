package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

class LottoInputView {

    fun readPurchaseAmount(): Int = readInt(READ_PURCHASE_AMOUNT_MESSAGE)

    fun readBonusBallNumber(): Int = readInt(READ_BONUS_BALL_NUMBER_MESSAGE)

    private fun readInt(message: String): Int {
        println(message)
        return readln().toIntOrNull() ?: 0
    }

    fun readLottoNumbers(message: String = DEFAULT_READ_LOTTO_NUMBER_MESSAGE): LottoNumbers {
        println(message)
        val input = readln()
        val numbers = input.split(DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER)
            .map { LottoNumber(it.trim().toIntOrNull() ?: 0) }
        return LottoNumbers(numbers)
    }

    companion object {
        private const val DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER = ","
        private const val READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val READ_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val DEFAULT_READ_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
    }
}
