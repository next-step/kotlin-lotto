package lotto.view

import lotto.domain.Ticket

class OutputView {

    fun printTicketPurchaseCount(count: Int) = println("${count}개를 구매했습니다.")

    fun printTicketsInfo(tickets: List<Ticket>) = tickets.forEach { ticket ->
        print("[")
        print(ticket.numbers.joinToString(", "))
        println("]")
    }
}
