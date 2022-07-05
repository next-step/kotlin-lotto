package lotto.domain

object LottoMarket {

    private const val LOTTO_PRICE = 1_000

    fun buyManual(user: User, lottos: List<Lotto>): LottoPaper {
        check(user.money.value >= lottos.size * LOTTO_PRICE) { "Not enough money" }
        user.pay(Money(lottos.size * LOTTO_PRICE))

        return lottos.toLottoPaper()
    }

    fun buyMaxAutomation(user: User): LottoPaper {
        val maxAmount = user.money.value / LOTTO_PRICE
        user.pay(Money(maxAmount * LOTTO_PRICE))

        return (1..maxAmount).map { Lotto.random() }.toLottoPaper()
    }

    private fun List<Lotto>.toLottoPaper() = LottoPaper(this)
}
