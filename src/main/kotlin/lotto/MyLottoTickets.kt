package lotto

class MyLottoTickets(
    val lottoTickets: List<LottoTicket>,
) {
    fun getMyLottoResult(lottoJudgment: LottoJudgment): Map<LottoWinnerPolicy, Int> {
        return lottoTickets
            .map { lottoJudgment.matchNumberCount(it) }
            .associateBy { lottoJudgment.getPrice(it) }
    }
}
