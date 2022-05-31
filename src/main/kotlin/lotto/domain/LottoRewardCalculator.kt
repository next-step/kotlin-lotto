package lotto.domain

class LottoRewardCalculator(
    private val lottoTickets: LottoTickets,
    private val winningNumbers: LottoWinningNumber
) {

    fun calculateRewardRate(purchaseAmount: Int, lottoTicketPrice: Int): Double {
        require(purchaseAmount > lottoTicketPrice) {
            "구입 금액은 로또 티켓 가격 보다 커야 합니다."
        }
        return calculateReward() / purchaseAmount.toDouble()
    }

    private fun calculateReward(): Double {
        return LottoMatchType.values()
            .sumOf { lottoTickets.getMatchCount(it.matchCount, winningNumbers) * it.reward }
            .toDouble()
    }
}
