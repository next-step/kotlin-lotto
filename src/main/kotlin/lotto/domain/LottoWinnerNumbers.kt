package lotto.domain

data class LottoWinnerNumbers(val lottoNumbers: LottoNumbers, val bonusNumber: LottoNumber) {
    init {
        require(!lottoNumbers.contains(bonusNumber)) { INVALID_WINNER_NUMBERS_MESSAGE }
    }

    fun resultLottoPayout(purchasedLottoTickets: PurchasedLottoTickets): PurchasedLottoResults {
        val rankCounts: Map<LottoWinnerRank, Int> =
            purchasedLottoTickets.purchasedLottoTickets
                .map { lottoTicket -> lottoTicket.checkLottoWinnerRank(this) }
                .groupingBy { it }
                .eachCount()

        return PurchasedLottoResults(
            purchasedCount = purchasedLottoTickets.purchasedCount,
            firstRankCount = rankCounts[LottoWinnerRank.FIRST] ?: 0,
            secondRankCount = rankCounts[LottoWinnerRank.SECOND] ?: 0,
            thirdRankCount = rankCounts[LottoWinnerRank.THIRD] ?: 0,
            fourthRankCount = rankCounts[LottoWinnerRank.FOURTH] ?: 0,
            fifthRankCount = rankCounts[LottoWinnerRank.FIFTH] ?: 0,
        )
    }

    companion object {
        const val INVALID_WINNER_NUMBERS_MESSAGE: String = "당첨 번호와 보너스 번호는 중복될 수 없습니다."
    }
}
