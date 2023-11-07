package lotto.domain

object LottoWinningMatcher {
    fun match(lottos: List<Lotto>, winningNumbers: List<Int>): List<Lotto> {
        return lottos.map { lotto ->
            performEachMatch(lotto, winningNumbers)
        }
    }

    private fun performEachMatch(lotto: Lotto, winningNumbers: List<Int>): Lotto {
        val correctCount = winningNumbers.count { lotto.numbers.contains(it) }

        return lotto.copy(winning = LottoWinning.of(correctCount))
    }
}
