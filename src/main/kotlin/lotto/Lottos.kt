package lotto

class Lottos(private val lottos: List<Lotto>) {
    fun calculateAllMatchCounts(winningNumbers: WinningNumbers): List<Int> {
        return lottos.map { lotto ->
            lotto.calculateMatchCount(winningNumbers)
        }
    }
}
