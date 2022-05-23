package lotto.agency

class LottoJudge {

    fun determineLottoWinnings(lottoTickets: List<LottoTicket>, wonLottoTicket: LottoTicket): Map<LottoWinning, Int> {
        val lottoWinningEnums = LottoWinning.values()
            .associateWith { INIT_WINNING_COUNT }
            .toMutableMap()

        val determinedLottoWinnings = lottoTickets
            .map { LottoWinning.of(it.countMatchWonLottoTicket(wonLottoTicket)) }
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        lottoWinningEnums.putAll(determinedLottoWinnings)
        return lottoWinningEnums
    }

    companion object {
        const val INIT_WINNING_COUNT = 0
    }
}
