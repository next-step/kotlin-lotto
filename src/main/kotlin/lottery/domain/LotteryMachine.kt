package lottery.domain

object LotteryMachine {
    fun purchase(tickets: List<Ticket>): List<Lottery> {
        return List(tickets.size) { Lottery.create() }
    }
}
