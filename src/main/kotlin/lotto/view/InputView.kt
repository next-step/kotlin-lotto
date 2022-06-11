package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.Money

object InputView {
    private const val NOT_GREATER_OR_EQUAL_NUMBER_MESSAGE = "0보다 작은 값은 입력할 수 없습니다."

    private fun String.splitToLottoNumber(): List<LottoNumber> {
        return this.replace(" ", "")
            .split(",")
            .mapNotNull { it.toIntOrNull() }
            .map { LottoNumber(it) }
    }

    fun getMoney(): Money {
        println("구입 금액을 입력해 주세요.")

        val money = readln().toInt()

        return Money(money)
    }

    fun getWinningNumbers(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readln().splitToLottoNumber()
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")

        return LottoNumber(
            readln().toInt()
        )
    }

    fun getManualTicketCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        val manualCount = readln().toInt()

        require(manualCount >= 0) { NOT_GREATER_OR_EQUAL_NUMBER_MESSAGE }

        return manualCount
    }

    fun getManualNumbers(manualTicketCount: Int): LottoTickets {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return LottoTickets(
            List(manualTicketCount) { readln() }
                .map { LottoTicket(it.splitToLottoNumber()) }
        )
    }
}
