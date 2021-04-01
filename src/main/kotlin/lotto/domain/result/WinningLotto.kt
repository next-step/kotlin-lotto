package lotto.domain.result

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets

class WinningLotto private constructor(val numbers: LottoTicket, private val bonusNumber: LottoNumber) {
    fun match(lottoTickets: LottoTickets): LottoResult {
        val matchInfos = lottoTickets.getMatchInfos(numbers, bonusNumber)
        return LottoRank.rank(matchInfos)
    }

    companion object {
        fun of(lottoNumbers: List<LottoNumber>, bonusNumber: String): WinningLotto {
            return WinningLotto(LottoTicket(lottoNumbers.toSet()), LottoNumber(bonusNumber))
        }
    }
}
