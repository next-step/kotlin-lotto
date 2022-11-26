package lotto.domain

class LottoStore(private val lottoGenerator: LottoGenerator) {

    fun buyLotto(cash: Cash): List<Lotto> {
        require(cash.amount >= Lotto.PRICE)

        val lottoCount = cash.amount / Lotto.PRICE

        return (1..lottoCount).map { lottoGenerator.generateLotto() }
    }
}
