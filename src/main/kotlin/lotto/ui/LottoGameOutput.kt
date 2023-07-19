package lotto.ui

import lotto.domain.GameMoney
import lotto.domain.LottoTicket
import lotto.domain.MatchResult

interface LottoGameOutput {
    fun printPurchasedTicket(lottoTicket: LottoTicket)
    fun printStatistics(matches: MatchResult, gameMoney: GameMoney)
}
