package lotto.domain

class LottoWinChecker(private val lottos: List<Lotto>) {

    fun getPrizes(winningNumbers: List<LottoNumber>): List<LottoPrize> {
        return lottos
            .mapNotNull {
                val matchCount = (it.numbers intersect winningNumbers).size
                LottoPrize.fromMatchCount(matchCount)
            }
            .sortedBy { it.matchCount }
    }
}
