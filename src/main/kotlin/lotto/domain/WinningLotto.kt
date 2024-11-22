package lotto.domain

class WinningLotto(private val lotto: Lotto) {
    fun getRank(lottoToCompare: Lotto): Rank {
        val matchCount = lottoToCompare.numbers.intersect(lotto.numbers).size
        return Rank.from(matchCount)
    }
}
