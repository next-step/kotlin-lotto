package lotto.agency

class LottoJudge {

    fun determineLottoWinnings(lottoTickets: List<LottoTicket>, wonLottoTicket: LottoTicket): Map<LottoWinning, Int> {
        val lottoWinningEnums = LottoWinning.values()
            .associateWith { INIT_WINNING_COUNT }
            .toMutableMap()

        val determinedLottoWinnings = lottoTickets
            .map { LottoWinning.of(it.countMatchWonLottoTicket(wonLottoTicket), isContainsBonus(it, wonLottoTicket)) }
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        lottoWinningEnums.putAll(determinedLottoWinnings)
        return lottoWinningEnums
    }

    private fun isContainsBonus(lottoTicket: LottoTicket, wonLottoTicket: LottoTicket): Boolean {
        return lottoTicket.numbers
            .map { it.number }
            .contains(wonLottoTicket.bonus?.number)
    }

    companion object {
        const val INIT_WINNING_COUNT = 0
    }
}
