package lotto.entity

interface Person {
    val wallet: Wallet
    fun purchaseLottoTicket(): Person
    fun markLottoTicket(numberOfManualTicket: Int, manualMarkedTickets: List<LottoTicket>): Person
}
