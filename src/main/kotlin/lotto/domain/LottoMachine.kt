package lotto.domain

class LottoMachine(val lottoPrice: Int = DEFAULT_LOTTO_PRICE) {
    fun autoPurchase(money: Int): Lottos {
        return Lottos(money / lottoPrice)
    }

    fun purchase(money: Int, manualNumbers: List<Set<Int>>): Lottos {
        val autoCount = (money / lottoPrice) - manualNumbers.size
        return Lottos(autoCount, manualNumbers)
    }

    companion object {
        private const val DEFAULT_LOTTO_PRICE = 1000
    }
}
