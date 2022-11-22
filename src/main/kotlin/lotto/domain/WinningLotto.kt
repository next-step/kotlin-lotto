package lotto.domain

class WinningLotto(private val winningNumbers: Lotto) {
    fun getMatchesCount(lotto: Lotto): Int = lotto.numbers.count { winningNumbers.numbers.contains(it) }
    fun getMatchesCount(lottos: List<Lotto>): List<Int> = lottos.map { getMatchesCount(it) }
}
