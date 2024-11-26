package lotto.step2.domain

object LottoMatcher {
    fun match(
        lottos: List<Lotto>,
        winningNumbers: List<Int>,
    ): List<Lotto> {
        return lottos.map { lotto ->
            val matchCount = lotto.pickNumbers.intersect(winningNumbers.toSet()).count()
            lotto.updateMatchCount(matchCount)
        }
    }
}
