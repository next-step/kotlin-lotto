package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {

    fun buyLotto(amount: Int): List<Lotto> {
        require(amount >= Lotto.PRICE)

        val lottoCount = amount / Lotto.PRICE

        return (1..lottoCount).map { lottoGenerator.generateLotto() }
    }
}
