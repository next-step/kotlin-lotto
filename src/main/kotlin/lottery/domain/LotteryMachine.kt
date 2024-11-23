package lottery.domain

object LotteryMachine {
    fun buy(tickets: List<Ticket>): List<Lottery> {
        return List(tickets.size) { Lottery.create() }
    }
}
