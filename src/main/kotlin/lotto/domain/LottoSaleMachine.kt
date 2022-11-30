package lotto.domain

object LottoSaleMachine {
    private const val LOTTO_TICKET_PRICE = 1000

    fun purchase(purchasePrice: Int): Int {
        return purchasePrice / LOTTO_TICKET_PRICE
    }
}