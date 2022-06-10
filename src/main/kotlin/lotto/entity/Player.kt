package lotto.entity

class Player(val wallet: Wallet) {

    fun getTickets(): List<LottoTicket> {
        return AutoPersonImpl().purchase(wallet.money)
    }
}
