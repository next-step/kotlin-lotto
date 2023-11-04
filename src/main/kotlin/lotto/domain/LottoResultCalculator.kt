package lotto.domain

class LottoResultCalculator(private val winningNumbers: List<Int>) {

    fun calculateResult(lottos: List<Lotto>): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()
        for (lotto in lottos) {
            val matchCount = winningNumbers.count { lotto.contains(it) }
            val rank = Rank.from(matchCount)
            val lottoCount = result.getOrDefault(rank, 0)
            result.putIfAbsent(rank, lottoCount + 1)
        }
        return result
    }
}
