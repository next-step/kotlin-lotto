package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.Money

object InputView {
    private const val NULL_MESSAGE = "입력값은 null일 수 없습니다."
    private const val NOT_GREATER_OR_EQUAL_NUMBER_MESSAGE = "0보다 작은 값은 입력할 수 없습니다."
    private const val NOT_VALID_NUMBER_MESSAGE = "유효한 로또 번호셋이 아닙니다. 로또 번호는 ,을 구분으로 입력되어야합니다."

    private fun String.splitToLottoNumber(): List<LottoNumber> {
        return this.replace(" ", "")
            .split(",")
            .mapNotNull { it.toIntOrNull() }
            .map { LottoNumber(it) }
    }

    fun getMoney(): Money {
        println("구입 금액을 입력해 주세요.")

        val money = readLine()?.toInt()

        requireNotNull(money) { NULL_MESSAGE }

        return Money(money)
    }

    fun getWinningNumbers(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return readln().splitToLottoNumber()
    }

    fun getBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine()?.toInt()

        requireNotNull(bonusNumber) { NULL_MESSAGE }

        return LottoNumber(bonusNumber)
    }

    fun getManualTicketCount(): Int {
        val manualCount = readLine()?.toInt()

        requireNotNull(manualCount) { NULL_MESSAGE }

        require(manualCount > 0) { NOT_GREATER_OR_EQUAL_NUMBER_MESSAGE }

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
