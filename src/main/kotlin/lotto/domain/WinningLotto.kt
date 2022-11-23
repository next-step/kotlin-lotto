package lotto.domain

class WinningLotto(private val winningNumbers: Lotto) {
    fun getCountOfMatch(lotto: Lotto): Int = lotto.numbers.count { winningNumbers.numbers.contains(it) }
    fun getCountOfMatch(lottos: List<Lotto>): List<Int> = lottos.map { getCountOfMatch(it) }
}
