package lotto.domain

class LottoShop(private val lottoGenerator: LottoGenerator) {
    fun buy(money: Money): List<Lotto> {
        val lottoCount = money.count()
        return (1..lottoCount).map { lottoGenerator.generate() }
    }
}
