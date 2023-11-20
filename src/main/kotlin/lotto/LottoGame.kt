package lotto

class LottoGame {

    fun getLottoCount(amount: Int): Int {
        return amount / PRICE_PER_LOTTO
    }

    fun start(count: Int): List<Lotto> {
        return mutableListOf<Lotto>().apply {
            repeat(count) {
                val lottoRange = (LOTTO_MIN_VALUE..LOTTO_MAX_VALUE).toList()
                val numbers = lottoRange.shuffled().take(LOTTO_COUNT).sorted()
                this.add(Lotto(numbers))
            }
        }
    }

    fun result(lottoList: List<Lotto>, lastNumbers: List<Int>, bonus: Int) {
        lottoList.forEach { lotto ->
            val count = (lotto.numbers + lastNumbers).groupBy { it }.filter { it.value.size > 1 }.count()
            val hasBonus = if (count == 5) hasMatchBonusBall(lotto.numbers, bonus) else false
            lotto.setRank(Rank.valueOf(count, hasBonus))
        }
    }

    private fun hasMatchBonusBall(numbers: List<Int>, bonus: Int): Boolean {
        return numbers.contains(bonus)
    }

    companion object {
        private const val PRICE_PER_LOTTO = 1000
        private const val LOTTO_MIN_VALUE = 1
        private const val LOTTO_MAX_VALUE = 45
        private const val LOTTO_COUNT = 6
    }
}
