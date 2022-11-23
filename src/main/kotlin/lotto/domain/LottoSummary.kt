package lotto.domain

class LottoSummary(
    lottoInfos: List<LottoInfo>,
) {
    val winners = LottoInfo.winner().map { lottoInfo ->
        LottoResult(lottoInfo, lottoInfos.count { lottoInfo.matchCount == it.matchCount })
    }
    val rateOfReturn: Double = lottoInfos.map { it.amount }.average() / TICKET_AMOUNT

    companion object {
        private const val TICKET_AMOUNT = 1000
    }
}
