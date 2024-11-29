package lotto.view

import lotto.domain.LottoTicket

object InputView {
    private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val AMOUNT_EXCEPTION_MESSAGE = "유효한 금액을 입력해 주세요."
    private const val INPUT_MANUAL_TICKET_COUNT = "수동으로 구매할 로또 수를 입력해 주세요."
    private const val QUANTITY_EXCEPTION_MESSAGE = "유효한 수량을 입력해 주세요."
    private const val INPUT_MANUAL_TICKETS = "수동으로 구매할 번호를 입력해 주세요."
    private const val INPUT_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요."
    private const val INPUT_NUMBER_EXCEPTION_MESSAGE = "당첨 숫자를 쉼표로 구분하여 입력해 주세요."
    private const val LOTTO_NUMBERS_SPLIT_UNIT = ","

    fun askPurchaseAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT)
        return readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException(AMOUNT_EXCEPTION_MESSAGE)
    }

    fun askManualPurchaseAmount(): Int {
        println(INPUT_MANUAL_TICKET_COUNT)
        return readlnOrNull()?.toIntOrNull() ?: throw IllegalArgumentException(QUANTITY_EXCEPTION_MESSAGE)
    }

    fun askManualPurchaseNumbers(manualTicketCount: Int): List<List<Int>> {
        println(INPUT_MANUAL_TICKETS)
        val manualTickets = mutableListOf<List<Int>>()

        repeat(manualTicketCount) {
            val input = readln().trim()
            val numbers =
                input.split(LOTTO_NUMBERS_SPLIT_UNIT)
                    .mapNotNull { it.trim().toIntOrNull() }
            manualTickets.add(numbers)
        }

        return manualTickets
    }

    fun askBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        return readln().toInt()
    }

    fun askWinningNumbers(): List<Int> {
        println(INPUT_LAST_WINNING_NUMBER)
        val numbers =
            readlnOrNull()?.split(LOTTO_NUMBERS_SPLIT_UNIT)?.map { it.trim().toInt() }
                ?: throw IllegalArgumentException(INPUT_NUMBER_EXCEPTION_MESSAGE)

        LottoTicket(numbers)
        return numbers
    }
}
