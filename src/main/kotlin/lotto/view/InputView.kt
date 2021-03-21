package lotto.view

import lotto.model.Money
import lotto.model.number.CandidateNumber
import lotto.model.number.CandidateNumbers
import lotto.model.number.WinningNumbers

object InputView {
    private fun readLine(message: String): String {
        var input: String? = null

        while (input.isNullOrBlank()) {
            if (message.isNotEmpty()) {
                println(message)
            }
            input = readLine()
        }

        return input
    }

    fun readMoney(): Money {
        return Money(readLine("구입금액을 입력해 주세요.").toInt())
    }

    fun readManualTicketCount(): Int {
        return readLine("수동으로 구매할 로또 수를 입력해 주세요.").toInt()
    }

    fun readWinningNumbers(): WinningNumbers {
        return WinningNumbers(
            readLine("지난 주 당첨 번호를 입력해 주세요.").split(",").map { it.toInt() }
        )
    }

    fun readBonusNumber(): CandidateNumber {
        return CandidateNumber.get(readLine("보너스 볼을 입력해 주세요.").toInt())
    }

    fun readCandidateNumbers(times: Int): List<CandidateNumbers> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return (1..times).map {
            CandidateNumbers(readLine("").split(",").map { it.toInt() })
        }
    }
}
