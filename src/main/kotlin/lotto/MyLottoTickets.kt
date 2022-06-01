package lotto

class MyLottoTickets(
    val manualLottery: List<LottoTicket> = listOf(),
    val autoLottery: List<LottoTicket> = listOf(),
) {
    private val lottoTickets: List<LottoTicket> = manualLottery + autoLottery

    fun getMyLottoResult(lastWinningLotto: LastWinningLotto): MyLottoResult {
        val eachCount: Map<LottoWinnerRank, Int> = lottoTickets
            .map(lastWinningLotto::getRanking)
            .groupingBy { it }
            .eachCount()

        return MyLottoResult(eachCount)
    }
}
