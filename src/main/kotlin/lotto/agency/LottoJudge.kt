package lotto.agency

import lotto.LottoTicket

class LottoJudge {

    fun determineWinning(lottoTickets: List<LottoTicket>, wonLottoNumbers: List<Int>): Map<LottoWinningEnum?, Int> {

        return lottoTickets
            .map { LottoWinningEnum.of(countMatchLottoNumber(it, wonLottoNumbers)) }
            .groupingBy { it }
            .eachCount()
    }

    private fun countMatchLottoNumber(lottoTicket: LottoTicket, wonLottoNumbers: List<Int>): Int {

        return lottoTicket.numbers
            .sorted()
            .count { wonLottoNumbers.contains(it) }
    }
}
