package specific.lotto.domain

class Store(val machine: Machine = Machine.RandomNumberMachine()) {

    fun buyTickets(money: Money): List<Ticket> {
        val count = money.remain / Ticket.PRICE
        money.spend(Ticket.PRICE * count)
        return List(count) { Ticket(machine.generateNumberCombination()) }
    }
}
