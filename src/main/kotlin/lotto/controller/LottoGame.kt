package lotto.controller

import lotto.domain.BuyingLotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumberTokenizer
import lotto.domain.LottoTicket
import lotto.domain.ResultLottoStatistics
import lotto.domain.WinningLottoNumbers
import lotto.domain.WinningLottoStatistics
import lotto.view.InputView

class LottoGame(
    private val buyingLotto: BuyingLotto
) {

    fun start(): LottoTicket {
        return LottoMachine.buy(buyingLotto)
    }

    fun doResult(lottoTicket: LottoTicket): ResultLottoStatistics {
        val stringLottoNumbers = InputView.enterLastWeekWinningLottoNumbers()
        val winningLottoNumberTokens = LottoNumberTokenizer.tokenize(stringLottoNumbers)
        val bonusNumber = InputView.enterBonusNumber()

        val winningLottoNumbers = WinningLottoNumbers.of(winningLottoNumberTokens, bonusNumber)
        val winningLottoStatistics = WinningLottoStatistics(lottoTicket, winningLottoNumbers)
        val lottoProfitRate = winningLottoStatistics.calculateProfitRate(buyingLotto.price)

        return ResultLottoStatistics(
            winningLottoStatistics,
            lottoProfitRate
        )
    }
}
