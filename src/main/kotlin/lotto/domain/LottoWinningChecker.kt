package lotto.domain

object LottoWinningChecker {
    fun check(lottos: List<Lotto>, winningNumbers: List<Int>): List<Lotto> {
        return lottos.map { lotto ->
            performEachCheck(lotto, winningNumbers)
        }
    }

    private fun performEachCheck(lotto: Lotto, winningNumbers: List<Int>): Lotto {
        val correctCount = winningNumbers.count { lotto.numbers.contains(it) }

        return lotto.copy(winning = LottoWinning.of(correctCount))
    }
}
