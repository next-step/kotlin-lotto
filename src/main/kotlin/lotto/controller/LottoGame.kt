package lotto.controller

import lotto.domain.BuyingLotto
import lotto.domain.LottoMachine
import lotto.domain.LottoNumberTokenizer
import lotto.domain.LottoPrice
import lotto.domain.LottoTicket
import lotto.domain.ResultLottoStatistics
import lotto.domain.WinningLottoNumbers
import lotto.domain.WinningLottoStatistics
import lotto.view.InputView

object LottoGame {

    fun start(buyingLotto: BuyingLotto): LottoTicket {
        return LottoMachine.buy(buyingLotto)
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
