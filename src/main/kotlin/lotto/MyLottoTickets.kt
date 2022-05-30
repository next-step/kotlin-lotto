package lotto

class MyLottoTickets(
    val manualLottery: List<LottoTicket> = listOf(),
    val autoLottery: List<LottoTicket> = listOf(),
) {
    private val lottoTickets: List<LottoTicket> = manualLottery + autoLottery

    fun getMyLottoResult(lottoJudgment: LottoJudgment): MyLottoResult {
        val eachCount: Map<LottoWinnerRank, Int> = lottoTickets
            .map(lottoJudgment::getRanking)
            .groupingBy { it }
            .eachCount()

        return MyLottoResult(eachCount)
    }
}
