package lotto.view

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.Money

object InputView {
    private const val NULL_MESSAGE = "입력값은 null일 수 없습니다."
    private const val NOT_GREATER_OR_EQUAL_NUMBER_MESSAGE = "0보다 작은 값은 입력할 수 없습니다."

    fun getMoney(): Money {
        println("구입 금액을 입력해 주세요.")

        val money = readLine()?.toInt()

        requireNotNull(money) { NULL_MESSAGE }

        return Money(money)
    }

    fun getWinningNumbers(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")

        val winningValue = readLine()
            ?.replace(" ", "")
            ?.split(",")
            ?.mapNotNull { it.toIntOrNull() }
            ?.map { LottoNumber(it) }

        requireNotNull(winningValue) { NULL_MESSAGE }

        return winningValue
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

    fun getManualNumbers(manualTicketCount: Int): Any {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return List(manualTicketCount) { readln() }
            .map { input ->
                LottoTicket(
                    input.replace(" ", "")
                        .split(",")
                        .map { LottoNumber(it.toInt()) }
                )
            }
    }
}
