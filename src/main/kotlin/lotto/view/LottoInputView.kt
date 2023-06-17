package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers

class LottoInputView {

    fun readPurchaseAmount(): Int = readInt(READ_PURCHASE_AMOUNT_MESSAGE)

    fun readBonusBallNumber(): Int = readInt(READ_BONUS_BALL_NUMBER_MESSAGE)

    fun readManualLotteryTicketCount(): Int = readInt(READ_MANUAL_LOTTERY_TICKET_COUNT_MESSAGE)

    private fun readInt(message: String): Int {
        println(message)
        return readln().toIntOrNull() ?: 0
    }

    fun readLastWeekWinningLottoNumbers(): LottoNumbers {
        println(READ_LAST_WEEK_WINNING_LOTTO_NUMBER_MESSAGE)
        return readLottoNumbers()
    }

    fun readManualLottoNumbers(manualLotteryTicketCount: Int = 0): List<LottoNumbers> {
        return if (manualLotteryTicketCount > 0) {
            println(READ_MANUAL_LOTTERY_TICKET_MESSAGE)
            (1..manualLotteryTicketCount).map { readLottoNumbers() }
        } else {
            emptyList()
        }
    }

    private fun readLottoNumbers(): LottoNumbers {
        val input = readln()
        val numbers = input.split(DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER)
            .map { LottoNumber(it.trim().toIntOrNull() ?: 0) }
        return LottoNumbers(numbers)
    }

    companion object {
        private const val DEFAULT_LAST_WEEK_WINNING_NUMBER_DELIMITER = ","
        private const val READ_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
        private const val READ_BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요."
        private const val READ_LAST_WEEK_WINNING_LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
        private const val READ_MANUAL_LOTTERY_TICKET_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
        private const val READ_MANUAL_LOTTERY_TICKET_MESSAGE = "수동으로 구매할 번호를 입력해 주세요."
    }
}
