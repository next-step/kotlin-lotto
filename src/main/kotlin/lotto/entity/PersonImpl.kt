package lotto.entity

class PersonImpl(override val wallet: Wallet) : Person {
    override fun purchase(): List<LottoTicket> {
        val money = wallet.money
        return LottoTicketMachine.printMaxTicket(money)
    }

    override fun money(): Int {
        return wallet.money
    }
}
