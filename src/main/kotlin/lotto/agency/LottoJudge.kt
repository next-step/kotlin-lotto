package lotto.agency

class LottoJudge {

    fun determineLottoWinnings(lottoTickets: List<LottoTicket>, wonLottoTicket: LottoTicket, bonusLottoNumber: Int): Map<LottoWinning, Int> {
        val lottoWinningEnums = LottoWinning.values()
            .associateWith { INIT_WINNING_COUNT }
            .toMutableMap()

        val determinedLottoWinnings = lottoTickets
            .map { LottoWinning.of(it.countMatchWonLottoTicket(wonLottoTicket), isContainsBonusLottoNumber(it, bonusLottoNumber)) }
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        lottoWinningEnums.putAll(determinedLottoWinnings)
        return lottoWinningEnums
    }

    private fun isContainsBonusLottoNumber(lottoTicket: LottoTicket, bonusLottoNumber: Int): Boolean {
        return lottoTicket.numbers.contains(bonusLottoNumber)
    }

    companion object {
        const val INIT_WINNING_COUNT = 0
    }
}
