package lotto.domain

private const val LOTTO_PRICE = 1000

object LotteryShop {
    fun buy(money: Int): Int {
        return money / LOTTO_PRICE
    }

    fun getTickets(lottoCount: Int): List<Lotto> {
        val tickets = mutableListOf<Lotto>()
        (0 until lottoCount).forEach { _ ->
            tickets.add(Lotto())
        }
        return tickets
    }
}