package lotto.domain

object LotteryShop {
    private const val LOTTO_PRICE = 1000
    fun buy(money: Int): Int {
        return money / LOTTO_PRICE
    }

    fun getTickets(lottoCount: Int): Tickets {
        return Tickets(lottoCount, AutoNumGenerator())
    }
}
