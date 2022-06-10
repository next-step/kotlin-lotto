package lotto.entity

class PersonImpl(override val wallet: Wallet) : Person {
    override fun purchase(): MutableList<LottoTicket> {
        val money = wallet.money
        return LottoTicketMachine().printMaxTicket(money)
    }
}
