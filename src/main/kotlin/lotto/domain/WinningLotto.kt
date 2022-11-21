package lotto.domain

class WinningLotto(private val winningNumbers: Lotto) {
    fun getMatchesCount(lotto: Lotto): Int = lotto.numbers.count { num -> winningNumbers.numbers.contains(num) }
    fun getMatchesCount(lottos: List<Lotto>): List<Int> = lottos.map { lotto -> getMatchesCount(lotto) }
}
