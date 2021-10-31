package lotto.controller

import lotto.domain.Budget
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.PurchaseInformation
import lotto.utils.StringUtils
import lotto.views.InputView
import lotto.views.OutputView

class LottoController {

    fun startLottoGame() {
        val purchaseInformation = getPurchaseInformation()
        val lottos = Lottos.createLottos(purchaseInformation)
        OutputView.showInputResult(lottos, purchaseInformation)
        val winningLottoInformation = getWinningLottoInformation()
        val lottoResult = LottoResult.EMPTY.getLottoResult(lottos, winningLottoInformation)
        OutputView.showResult(lottoResult, purchaseInformation)
    }

    private fun getWinningLottoInformation(): Pair<Lotto, LottoNumber> {
        val winningLotto = Lotto(StringUtils.toLottoNumbers(InputView.askWinningLotto()))
        val bonusNumber = LottoNumber.valueOf(InputView.askBonusNumber())
        return Pair(winningLotto, bonusNumber)
    }

    private fun getPurchaseInformation(): PurchaseInformation {
        val budgets = Budget.valueOf(InputView.askLottoBudget())
        val manualCount = InputView.askManualLottoCount()
        return PurchaseInformation(budgets, manualCount)
    }
}
