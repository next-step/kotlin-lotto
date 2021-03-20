package lotto.domain

class LottoStore  {
    fun getPurchasableLottoCount(budget: Int): Int {
        return budget / LOTTO_DEFAULT_PRICE
    }

    fun buyLotto(count: Int): List<Lotto> {
        val lotto = mutableListOf<Lotto>()
        repeat(count) {
            lotto.add(LottoGenerator.generateLotto())
        }

        return lotto
    }

    companion object {
        private const val LOTTO_DEFAULT_PRICE = 1000
    }

}
