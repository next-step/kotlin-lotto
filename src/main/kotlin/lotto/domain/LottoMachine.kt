package lotto.domain

class LottoMachine {

    fun buy(price: Int): Lottos {
        val availableLottoCount = getAvailableLottoCount(price)
        generateLotto(availableLottoCount)

        return generateLotto(availableLottoCount)
    }

    private fun getAvailableLottoCount(price: Int): Int {
        return price / Lotto.LOTTO_PRICE
    }

    private fun generateLotto(availableLottoCount: Int): Lottos {
        return Lottos(List(availableLottoCount) { Lotto.of(LottoNumberGenerator.generate()) })
    }
}
