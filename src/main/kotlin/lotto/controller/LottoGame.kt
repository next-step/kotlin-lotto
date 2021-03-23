package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberTokenizer
import lotto.domain.LottoPrice
import lotto.domain.LottoTicket
import lotto.domain.WinningLottoNumbers
import lotto.domain.WinningLottoStatistics
import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.generator.ManualLottoGenerator
import lotto.view.InputView
import lotto.vo.ResultLottoStatistics

object LottoGame {

    fun start(price: LottoPrice, manualLottoCount: Int): LottoTicket {
        val lottoMachine = LottoMachine(AutoLottoGenerator())
        val automaticLottoCount = price.calculateAutomaticCount(manualLottoCount)
        val manualLottoNumbers = (1..manualLottoCount).map { askManualLotto() }
        val automaticLottos = (1..automaticLottoCount).map { lottoMachine.buy() }
        val manualLottos = manualLottoNumbers.map {
            lottoMachine.setGenerator(ManualLottoGenerator(it))
            lottoMachine.buy()
        }
        val lottoTicket = LottoTicket(
            manuals = manualLottos,
            automatics = automaticLottos
        )

        validateLottoCount(price, lottoTicket)

        return lottoTicket
    }

    private fun validateLottoCount(price: LottoPrice, lottoTicket: LottoTicket) {
        require(price.isExceedPriceByCount(lottoTicket.totalLottoCount())) {
            "로또 구매수는 구입금액을 초과할 수 없습니다."
        }
    }

    private fun askManualLotto(): String {
        return InputView.enterManualLottoNumbers()
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
