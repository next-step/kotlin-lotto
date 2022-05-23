package lotto.agency

class LottoJudge {

    fun determineLottoWinnings(lottoTickets: List<LottoTicket>, wonLottoNumbers: List<Int>): Map<LottoWinning, Int> {
        val lottoWinningEnums = LottoWinning.values()
            .associateWith { INIT_WINNING_COUNT }
            .toMutableMap()

        val determinedLottoWinnings = lottoTickets
            .mapNotNull { LottoWinning.of(countMatchLottoNumber(it, wonLottoNumbers)) }
            .groupingBy { it }
            .eachCount()
            .toMutableMap()

        lottoWinningEnums.putAll(determinedLottoWinnings)
        return lottoWinningEnums
    }

    private fun countMatchLottoNumber(lottoTicket: LottoTicket, wonLottoNumbers: List<Int>): Int {

        return lottoTicket.numbers
            .sorted()
            .count { wonLottoNumbers.contains(it) }
    }

    companion object {
        const val INIT_WINNING_COUNT = 0
    }
}
