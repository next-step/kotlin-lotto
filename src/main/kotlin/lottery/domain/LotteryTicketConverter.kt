package lottery.domain

object LotteryTicketConverter {
    fun convertToTickets(money: Money): List<Ticket> {
        require(money.amount >= 1000) { "금액은 1000원 이상이어야 합니다" }
        require(money.amount % 1000 == 0) { "금액은 1000원 단위여야 합니다" }
        val ticketCount = money.amount / 1000
        return List(ticketCount) { Ticket() }
    }
}
