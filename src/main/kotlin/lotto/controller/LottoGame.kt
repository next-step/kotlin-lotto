package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberTokenizer
import lotto.domain.LottoPrice
import lotto.domain.LottoTicket
import lotto.domain.ManualNumbers
import lotto.domain.ResultLottoStatistics
import lotto.domain.WinningLottoNumbers
import lotto.domain.WinningLottoStatistics
import lotto.view.InputView

object LottoGame {

    fun start(price: LottoPrice, manualNumbers: ManualNumbers): LottoTicket {
        return LottoMachine.buy(price, manualNumbers)
    }

    fun doResult(lottoTicket: LottoTicket, buyingPrice: LottoPrice): ResultLottoStatistics {
        val stringLottoNumbers = InputView.enterLastWeekWinningLottoNumbers()
        val winningLottoNumberTokens = LottoNumberTokenizer.tokenize(stringLottoNumbers)
        val bonusNumber = InputView.enterBonusNumber()

        val winningLottoNumbers = WinningLottoNumbers.of(winningLottoNumberTokens, bonusNumber)
        val winningLottoStatistics = WinningLottoStatistics(lottoTicket, winningLottoNumbers)
        val lottoProfitRate = winningLottoStatistics.calculateProfitRate(buyingPrice)

        return ResultLottoStatistics(
            winningLottoStatistics,
            lottoProfitRate
        )
    }
}
