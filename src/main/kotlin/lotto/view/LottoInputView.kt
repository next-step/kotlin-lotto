package lotto.view

import lotto.domain.BonusNumber
import lotto.domain.Ticket

class LottoInputView {
    fun inputTicketCost(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun inputManualCount(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun inputManualTickets(count: Int): List<String> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        return (0 until count).map { readLine()!! }
    }

    fun printTickets(manualCount: Int, tickets: List<Ticket>) {
        println("\n수동으로 ${manualCount}장, 자동으로 ${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.toPrintable())
        }
        println()
    }

    private fun Ticket.toPrintable(): String {
        return numbers.sorted().joinToString(prefix = "[", postfix = "]", separator = ", ") { "$it" }
    }

    fun inputWinningTicket(): Ticket {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Ticket(readLine()!!.split(",").map { it.trim().toInt() }.toSet())
    }

    fun inputBonusNumber(): BonusNumber {
        println("보너스 볼을 입력해 주세요.")
        return BonusNumber(readLine()!!.toInt())
    }
}
