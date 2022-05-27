package lotto

class MyLottoTickets(
    val lottoTickets: List<LottoTicket>,
) {
    fun getMyLottoResult(lottoJudgment: LottoJudgment): MyLottoResult {
        val eachCount: Map<LottoWinnerRank, Int> = lottoTickets
            .map(lottoJudgment::getRanking)
            .groupingBy { it }
            .eachCount()

        return MyLottoResult(eachCount)
    }
}
