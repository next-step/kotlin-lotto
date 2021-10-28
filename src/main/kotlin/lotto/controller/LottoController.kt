package lotto.controller

import lotto.domain.Budget
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.utils.StringUtils
import lotto.views.InputView
import lotto.views.OutputView

class LottoController {

    fun startLottoGame() {
        val budgets = Budget.valueOf(InputView.askLottoBudget())
        val lottos = Lottos.createLottos(budgets)
        OutputView.showInputResult(lottos, budgets)
        val winningLotto = Lotto(StringUtils.toLottoNumbers(InputView.askWinningLotto()))
        val bonusNumber = LottoNumber.valueOf(InputView.askBonusNumber())
        val matchedRewards = lottos.getMatchedRewards(winningLotto, bonusNumber)
        val lottoResult = LottoResult.EMPTY.updateRewards(matchedRewards)
        OutputView.showResult(lottoResult, budgets)
    }
}
