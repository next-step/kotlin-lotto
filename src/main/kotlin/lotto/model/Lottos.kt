package lotto.model

class Lottos(val value: List<Lotto>) : List<Lotto> by value {
    fun matchCounts(winningNumbers: WinningNumbers): List<Int> {
        return value.map { winningNumbers.matchCount(it) }
    }
}
