package lotto.controller

import lotto.domain.Amount
import lotto.domain.LottoGame
import lotto.domain.LottoNumber
import lotto.entity.Lotto
import lotto.view.InputView
import lotto.view.OutPutView

class LottoController(private val lottoGame: LottoGame) {
    fun gameStart() {
        val amount = InputView.getAmount()
        val lottoManualNumbers = InputView.getLottoManualNumbers(amount.manualCount)
        val lottoInfo = createLottoInfo(amount, lottoManualNumbers)
        OutPutView.printLottoInfo(lottoInfo)

        gameEnd(lottoInfo, amount.amount)
    }

    private fun gameEnd(
        lottoInfo: Lotto,
        amount: Int,
    ) {
        val winnerNumbers = InputView.getWinningNumber()
        val lottoGameResult = lottoGame.getLottoGameResult(lottoInfo, winnerNumbers)
        OutPutView.printLottoResults(lottoGameResult.getResult(), amount)
    }

    private fun createLottoInfo(
        amount: Amount,
        lottoManualNumbers: List<LottoNumber>,
    ): Lotto {
        return lottoGame.start(amount, lottoManualNumbers)
    }
}
