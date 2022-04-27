package lotto.ui

import lotto.domain.ticket.LottoGame
import lotto.domain.ticket.WinningStatistics

interface Output {
    fun outputRequestToEnterHowManyBuyLottoGames()
    fun outputNumberOfLottoGames(numberOfLottoGames: Int)
    fun outputNumberOfLottoGames(lottoGames: List<LottoGame>)
    fun outputWinningNumbersLastWeek()
    fun outputLottoGameResult(winningStatistics: WinningStatistics)
}
