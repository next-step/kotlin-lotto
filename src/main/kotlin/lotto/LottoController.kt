package lotto

import lotto.domain.LottoMachine
import lotto.domain.LottoNumberGenerator
import lotto.ui.InputView
import lotto.ui.OutputView

class LottoController(
    private val outputView: OutputView,
    private val inputView: InputView,
    private val lottoNumberGenerator: LottoNumberGenerator
) {

    fun execute() {
        val price = inputView.readPrice()
        val manualLottoCount = inputView.readManualLottoCount(price)
        val manualLottoNumbers = inputView.readManualLottoNumbers(manualLottoCount)
        val lottos = LottoMachine(lottoNumberGenerator).buy(manualLottoCount, manualLottoNumbers)
        outputView.printLottos(lottos)

        val winningNumbers = inputView.readWinningAndBonusNumbers()
        val result = lottos.getLottoResult(winningNumbers)
        outputView.printLottoResult(result)
    }
}
