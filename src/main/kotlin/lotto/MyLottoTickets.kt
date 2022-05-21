package lotto

class MyLottoTickets(
    val lottoTickets: List<LottoTicket>,
) {
    fun getMyLottoResult(lottoJudgment: LottoJudgment): MyLottoResult {
        val result = lottoTickets
            .map { lottoJudgment.matchNumberCount(it) }
            .associateBy { lottoJudgment.getRanking(it) }

        return MyLottoResult(result)
    }

    fun getProfit(myLottoResult: MyLottoResult): Double {
        val totalEarningByLotto = myLottoResult.result
            .map { it.key.price * it.value }
            .sum()

        return (totalEarningByLotto / lottoTickets.size * LOTTO_PRICE).toDouble()
    }
}
