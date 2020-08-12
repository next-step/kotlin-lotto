package lotto.view

import lotto.domain.Ticket

class LottoInputView {
    fun inputTicketCost(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun printTickets(tickets: List<Ticket>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach {
            println(it.toPrintable())
        }
        println()
    }

    private fun Ticket.toPrintable(): String {
        return numbers.sorted().joinToString(prefix = "[", postfix = "]", separator = ", ") { "$it" }
    }

    fun inputwinningTicket(): Ticket {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return Ticket(readLine()!!.split(",").map { it.trim().toInt() }.toSet())
    }
}
