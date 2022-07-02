package lotto.domain

class LottoMarket {

    fun buyManual(user: User, lottos: List<Lotto>): LottoPaper {
        check(user.money.value >= lottos.size * LOTTO_PRICE) { "Not enough money" }
        user.money.sub(lottos.size * LOTTO_PRICE)

        return lottos.toLottoPaper()
    }

    fun buyMaxAutomation(user: User): LottoPaper {
        val maxAmount = user.money.value / LOTTO_PRICE
        user.money.sub(maxAmount * LOTTO_PRICE)

        return (1..maxAmount).map { Lotto.random() }.toLottoPaper()
    }

    private fun List<Lotto>.toLottoPaper() = LottoPaper(this)

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
