package lotto.domain

class LottoWinChecker(private val lottos: List<Lotto>) {
    fun checkWin(winningNumbers: List<Int>): List<LottoPrize?> {
        return lottos.map {
            val matchCount = (it.numbers intersect winningNumbers).size
            LottoPrize.fromMatchCount(matchCount)
        }
    }
}
