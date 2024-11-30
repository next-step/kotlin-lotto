package lotto

class Lottos(private val lottos: List<Lotto>) {
    fun calculateAllMatchCounts(winningNumbers: WinningNumbers): List<Int> {
        return lottos.map { lotto ->
            lotto.calculateMatchCount(winningNumbers)
        }
    }

    fun calculatePurchaseAmount(): Long {
        return (lottos.size * Lotto.MIN_AMOUNT_UNIT).toLong()
    }
}
