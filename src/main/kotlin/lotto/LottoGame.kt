package lotto

class LottoGame {

    fun getLottoCount(amount: Int): Int {
        return amount / PRICE_PER_LOTTO
    }

    fun getLottoList(count: Int): List<Lotto> {
        return mutableListOf<Lotto>().apply {
            repeat(count) { this.add(Lotto.of()) }
        }
    }

    fun result(lottoList: List<Lotto>, lastLotto: Lotto, bonus: Int): List<LottoResult?> {
        return lottoList.map { lotto ->
            val count = lotto.numbers.intersect(lastLotto.numbers).count()
            val hasBonus = if (count == 5) hasMatchBonusBall(lotto.numbers, bonus) else false
            Rank.valueOf(count, hasBonus)?.let {
                LottoResult(it).apply { this.addCount() }
            }
        }
    }

    fun getTotalWinningMoney(result: List<LottoResult?>): Int {
        return result.sumOf { it?.rank?.getWinningMoney(it.count) ?: 0 }
    }

    private fun hasMatchBonusBall(numbers: Set<Int>, bonus: Int): Boolean {
        return numbers.contains(bonus)
    }

    companion object {
        private const val PRICE_PER_LOTTO = 1000
    }
}
