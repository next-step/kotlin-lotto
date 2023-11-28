package lotto

class LottoGame {

    fun getLottoCount(amount: Int): Int {
        return amount / PRICE_PER_LOTTO
    }

    fun getLottoList(count: Int): List<Lotto> {
        return mutableListOf<Lotto>().apply {
            repeat(count) { this.add(Lotto.getAutoNumbers()) }
        }
    }

    fun result(lottoList: List<Lotto>, winningLotto: Lotto, bonus: Int): Map<Rank, Int> {
        return lottoList.mapNotNull { lotto ->
            lotto.match(winningLotto, bonus).let { (count, hasBonus) -> Rank.valueOf(count, hasBonus) }
        }.groupingBy { it }.eachCount()
    }

    fun getTotalWinningMoney(result: Map<Rank, Int>): Int {
        return result.toList().sumOf { it.first.getWinningMoney(it.second) }
    }

    companion object {
        private const val PRICE_PER_LOTTO = 1000
    }
}
