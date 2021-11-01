package lotto.controller

import lotto.domain.Budget
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.PurchaseInformation
import lotto.domain.WinningLottoInformation
import lotto.utils.StringUtils
import lotto.views.InputView
import lotto.views.OutputView

class LottoController {

    fun startLottoGame() {
        val budgets = Budget.valueOf(InputView.askLottoBudget())
        val manualCount = InputView.askManualLottoCount()
        val manualLottos = InputView.askManualLottos(manualCount)
        val purchaseInformation = PurchaseInformation(budgets, manualCount, manualLottos)
        val lottos = Lottos.createLottos(purchaseInformation)
        OutputView.showInputResult(lottos, purchaseInformation)

        val winningLotto = Lotto(StringUtils.toLottoNumbers(InputView.askWinningLotto()))
        val bonusNumber = LottoNumber.valueOf(InputView.askBonusNumber())
        val winningLottoInformation = WinningLottoInformation(winningLotto, bonusNumber)

        val lottoResult = LottoResult.EMPTY.getLottoResult(lottos, winningLottoInformation)
        OutputView.showResult(lottoResult, purchaseInformation)
    }
}
