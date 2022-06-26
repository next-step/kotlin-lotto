package lotto

import lotto.domain.BonusNumber
import lotto.domain.LottoMatcher
import lotto.domain.LottoShop
import lotto.domain.ManualLottoTotal
import lotto.domain.ManualLottos
import lotto.domain.PaidMoney
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val paidMoney = PaidMoney(InputView.getPurchaseAmount())
    val manualLottoCount = ManualLottoTotal(InputView.getManualLottoCount())
    val manualLottos = ManualLottos(InputView.getManualLottoNumbers(manualLottoCount.value))
    val lottoTickets = LottoShop().buyLotto(paidMoney, manualLottos)
    ResultView.showLottoInfo(lottoTickets, manualLottoCount)

    val winningLotto = WinningLotto(InputView.getWinningNumbers())
    val bonusNumber = BonusNumber(InputView.getBonusNumber())
    LottoMatcher.also { matcher ->
        val matchResult = matcher.matchResult(lottoTickets, winningLotto, bonusNumber)
        val earnedRate = matcher.calculateEarnedRate(matchResult.earnedMoney, paidMoney)
        ResultView.showMatchResult(matchResult, earnedRate)
    }
}
