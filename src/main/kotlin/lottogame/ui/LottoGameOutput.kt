package lottogame.ui

import lottogame.domain.GameMoney
import lottogame.domain.lotto.LottoTicket
import lottogame.domain.lotto.MatchResult

interface LottoGameOutput {
    fun printPurchasedTicket(lottoTicket: LottoTicket)
    fun printStatistics(matches: MatchResult, gameMoney: GameMoney)
}
