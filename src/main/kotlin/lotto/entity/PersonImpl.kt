package lotto.entity

import lotto.entity.LottoTicket.Companion.LOTTO_PRICE

class PersonImpl(override val wallet: Wallet) : Person {
    override fun mark(numberOfManualTicket: Int, manualMarkedTickets: List<LottoTicket>): Wallet {
        return Wallet(wallet.money - LOTTO_PRICE * numberOfManualTicket, manualMarkedTickets)
    }

    override fun purchase(): Wallet {
        return (LottoTicketMachine.printMaxTicket(wallet))
    }

    override fun money(): Int {
        return wallet.money
    }
}
