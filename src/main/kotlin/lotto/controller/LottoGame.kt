package lotto.controller

import lotto.domain.LottoMachine
import lotto.domain.LottoPrice
import lotto.domain.LottoTicket
import lotto.domain.WinningLottoNumbers
import lotto.domain.WinningLottoStatistics
import lotto.domain.generator.AutoLottoGenerator
import lotto.domain.generator.ManualLottoGenerator
import lotto.view.InputView
import lotto.vo.ResultLottoStatistics

object LottoGame {

    fun start(): LottoTicket {
        val price = LottoPrice(InputView.enterLottoBuyingPrice())
        val manualLottoCount = InputView.enterManualLottoCount()
        val automaticLottoCount = price.calculateAutomaticCount(manualLottoCount)
        val manualLottoNumbers = askManualLottos(manualLottoCount)

        return createTicket(price, automaticLottoCount, manualLottoNumbers)
    }

    private fun createTicket(
        price: LottoPrice,
        automaticLottoCount: Int,
        manualLottoNumbers: List<String>
    ): LottoTicket {
        val autoLottoMachine = LottoMachine(AutoLottoGenerator())
        val automaticLottos = (1..automaticLottoCount).map { autoLottoMachine.buy() }
        val manualLottos = manualLottoNumbers.map {
            LottoMachine(ManualLottoGenerator(it)).buy()
        }

        return LottoTicket(
            manualLottos = manualLottos,
            automaticLottos = automaticLottos,
            price = price
        )
    }

    private fun askManualLottos(manualLottoCount: Int): List<String> {
        return (1..manualLottoCount).map { askManualLotto() }
    }

    private fun askManualLotto(): String {
        return InputView.enterManualLottoNumbers()
    }

    fun doResult(lottoTicket: LottoTicket): ResultLottoStatistics {
        val stringLottoNumbers = InputView.enterLastWeekWinningLottoNumbers()
        val bonusNumber = InputView.enterBonusNumber()

        val winningLottoNumbers = WinningLottoNumbers.of(stringLottoNumbers, bonusNumber)
        val winningLottoStatistics = WinningLottoStatistics(lottoTicket, winningLottoNumbers)
        val lottoProfitRate = winningLottoStatistics.calculateProfitRate(lottoTicket.price)

        return ResultLottoStatistics(
            winningLottoStatistics,
            lottoProfitRate
        )
    }
}
