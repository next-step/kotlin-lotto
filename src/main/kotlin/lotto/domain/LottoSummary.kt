package lotto.domain

class LottoSummary(
    lottoInfos: List<LottoInfo>,
) {
    val winners = LottoInfo.winner().map { lottoInfo ->
        LottoResult(lottoInfo, countWinner(lottoInfos, lottoInfo))
    }
    val rateOfReturn: Double = lottoInfos.map { it.amount }.average() / TICKET_AMOUNT

    private fun countWinner(lottoInfos: List<LottoInfo>, lottoInfo: LottoInfo) =
        lottoInfos.count { lottoInfo.matchCount == it.matchCount && it.checkBonusBall(lottoInfo.isBonusBallMatched) }

    companion object {
        private const val TICKET_AMOUNT = 1000
    }
}
