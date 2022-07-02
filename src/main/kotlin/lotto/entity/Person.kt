package lotto.entity

interface Person {
    val wallet: Wallet
    fun purchase(): Wallet
    fun money(): Int
    fun mark(numberOfManualTicket: Int, manualMarkedTickets: List<LottoTicket>): Wallet
}
