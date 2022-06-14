package lotto.entity

interface Person {
    val wallet: Wallet
    fun purchase(): List<LottoTicket>
}
