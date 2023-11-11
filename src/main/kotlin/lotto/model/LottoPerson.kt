package lotto.model

class LottoPerson {

    companion object{
        fun buyLottoTicket(purchasePrice: Int): Int = purchasePrice / LottoTicket.TICKET_PRICE;

    }
}
