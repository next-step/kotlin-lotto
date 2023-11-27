package study.lotto.controller

import study.lotto.domain.BuyingLottoes
import study.lotto.domain.BuyingManualLottoes
import study.lotto.domain.Lotto
import study.lotto.domain.LottoGameResult
import study.lotto.domain.LottoNumber
import study.lotto.domain.LottoShop
import study.lotto.domain.Lottoes
import study.lotto.view.InputView
import study.lotto.view.ResultView

class LottoController(
    private val inputView: InputView,
    private val resultView: ResultView,
) {
    fun run() {
        val buyingLottoes = buyingLottoes()

        resultView.displayLottoes(buyingLottoes)

        val lastWeekWinningLotto = getLastWeekWinningLotto()
        val bonusNumber = getBonusLottoNumber()
        val lottoResult = getLottoGameResult(buyingLottoes, lastWeekWinningLotto, bonusNumber)

        resultView.displayStatistics(lottoResult.statistics)
        resultView.displayProfitRate(lottoResult.earningsRate)
    }

    private fun buyingLottoes() = LottoShop.buyLottoes(
        inputView.getPurchaseAmount(),
        getManualBuyingLottoNumbersList()
    )

    private fun getBonusLottoNumber() = inputView.getBonusNumber()

    private fun getLottoGameResult(
        buyingLottoes: BuyingLottoes,
        lastWeekWinningLotto: Lotto,
        bonusNumber: LottoNumber,
    ) = LottoGameResult.getResult(
        buyingLottoes,
        lastWeekWinningLotto,
        bonusNumber
    )

    private fun getLastWeekWinningLotto() = inputView.getLastWeekWinningNumbers()
        .let(::Lotto)

    private fun getManualBuyingLottoNumbersList() = inputView.getManualBuying()
}
