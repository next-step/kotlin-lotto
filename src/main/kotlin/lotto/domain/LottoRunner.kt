package lotto.domain

import lotto.domain.money.BuyMoney
import lotto.domain.rank.LottoRank
import lotto.domain.shop.LottoShop.quickPickBuy
import lotto.domain.ticket.LottoGame
import lotto.domain.ticket.WinningLottoNumbers
import lotto.domain.ticket.WinningStatistics
import lotto.domain.ticket.lottery.LotteryNumbers
import lotto.ui.InputConsole.inputLottoGamesBuyPrice
import lotto.ui.InputConsole.inputWinningNumbersForLastWeek
import lotto.ui.OutputConsole.outputLottoGameResult
import lotto.ui.OutputConsole.outputNumberOfLottoGames
import lotto.ui.OutputConsole.outputWinningNumbersLastWeek
import lotto.ui.OutputConsole.outputRequestToEnterHowManyBuyLottoGames
import lotto.util.LottoNumbersParser.splitToNumbers

object LottoRunner {

    fun start() {
        val lottoGamesBuyPrice = readHowManyBuyLottoGames()

        val lottoGames = buyLottoGame(lottoGamesBuyPrice)

        outputNumberOfLottoGames(lottoGames)

        val winningLottoNumbers = readWinningLottoNumbers()

        notifyLottoGameStatistics(
            lottoGamesBuyPrice = lottoGamesBuyPrice,
            winningLottoNumbers = winningLottoNumbers,
            lottoGames = lottoGames
        )
    }

    private fun readHowManyBuyLottoGames(): Int {
        outputRequestToEnterHowManyBuyLottoGames()
        return inputLottoGamesBuyPrice()
    }

    private fun buyLottoGame(lottoGamesBuyPrice: Int): List<LottoGame> {
        return quickPickBuy(BuyMoney(lottoGamesBuyPrice))
    }

    private fun readWinningLottoNumbers(): WinningLottoNumbers {
        outputWinningNumbersLastWeek()
        val winningLottoNumbers = splitToNumbers(inputWinningNumbersForLastWeek())

        return WinningLottoNumbers(LotteryNumbers.of(winningLottoNumbers))
    }

    private fun notifyLottoGameStatistics(
        lottoGamesBuyPrice: Int,
        winningLottoNumbers: WinningLottoNumbers,
        lottoGames: List<LottoGame>
    ) {
        val lottoGameRanks = lottoGames.map {
            LottoRank.from(winningLottoNumbers.numberOfMatchesWithWinningNumbers(it))
        }

        val winningStatistics = WinningStatistics(lottoGamesBuyPrice, lottoGameRanks)

        outputLottoGameResult(winningStatistics)
    }
}
