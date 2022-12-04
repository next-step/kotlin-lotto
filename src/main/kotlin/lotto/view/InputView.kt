package lotto.view

import lotto.util.Reader

object InputView {
    private const val INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val INPUT_MANUAL_TICKET_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요."
    fun readMoney(): Int {
        println(INPUT_MONEY_MESSAGE)
        return Reader.read().toInt()
    }

    fun readManualTicketCount(): Int {
        println(INPUT_MANUAL_TICKET_COUNT_MESSAGE)
        return Reader.read().toInt()
    }
}
