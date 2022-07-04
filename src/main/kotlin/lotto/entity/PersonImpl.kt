package lotto.entity

import lotto.entity.LottoTicket.Companion.LOTTO_PRICE

class PersonImpl(override val wallet: Wallet) : Person {
    override fun markLottoTicket(numberOfManualTicket: Int, manualMarkedTickets: List<LottoTicket>): PersonImpl {
        return PersonImpl(Wallet(wallet.money - LOTTO_PRICE * numberOfManualTicket, manualMarkedTickets))
    }

    override fun purchaseLottoTicket(): PersonImpl {
        return PersonImpl(LottoTicketMachine.printMaxTicket(wallet))
    }

    fun getMoney(): Int {
        return wallet.money
    }

    fun getTickets(): List<LottoTicket> {
        return wallet.tickets
    }
}
