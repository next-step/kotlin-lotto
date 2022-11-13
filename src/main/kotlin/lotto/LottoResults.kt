package lotto

private const val TICKET_PRICE = 1000

class LottoResults(
    val winnings: List<LottoResult>,
    val purchaseCount: Int
) {
    fun calculateWinningMoney(): Int {
        return winnings.sumOf { it.winningMoney }
    }

    fun calculateProfitRate(): Double {
        return calculateWinningMoney().toDouble() / (purchaseCount * TICKET_PRICE)
    }
}