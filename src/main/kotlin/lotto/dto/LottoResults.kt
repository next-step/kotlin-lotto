package lotto.dto

const val TICKET_PRICE: Int = 1000

class LottoResults(
    val winnings: List<LottoResult>,
    val purchaseCount: Int
) {
    private fun calculateWinningMoney(): Int {
        return winnings.sumOf { it.winningMoney }
    }

    fun calculateProfitRate(): Double {
        return calculateWinningMoney().toDouble() / (purchaseCount * TICKET_PRICE)
    }

    fun statistics(): List<StatisticResult> {
        return LottoResult.winningValues()
            .map { StatisticResult(it, countFromWinnings(it.matchCount, it.matchBonus)) }
    }

    private fun countFromWinnings(matchNumber: Int, matchBonus: Boolean): Int {
        return winnings.count { it.matchCount == matchNumber && it.matchBonus == matchBonus}
    }
}
