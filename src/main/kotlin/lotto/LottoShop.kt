package lotto

class LottoShop(private val lottoGenerator: LottoGenerator) {
    fun buy(money: Int): List<Lotto> {
        val lottoCount = money / LOTTO_PRICE
        return (1..lottoCount).map { lottoGenerator.generate() }
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}