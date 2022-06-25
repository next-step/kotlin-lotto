package lotto

import lotto.domain.BonusNumber
import lotto.domain.LottoMatcher
import lotto.domain.LottoShop
import lotto.domain.ManualLottoCount
import lotto.domain.ManualLottos
import lotto.domain.PaidMoney
import lotto.domain.WinningLotto
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val paidMoney = PaidMoney(InputView.getPurchaseAmount())
    val lottoTickets = LottoShop().buyLotto(paidMoney)
    ResultView.showLottoInfo(lottoTickets)
    val manualLottoCount = ManualLottoCount(InputView.getManualLottoCount())
    val manualLottoNumbers = ManualLottos(InputView.getManualLottoNumbers(manualLottoCount.value))

    val winningLotto = WinningLotto.from(InputView.getWinningNumbers())
    val bonusNumber = BonusNumber.from(InputView.getBonusNumber())
    LottoMatcher.also { matcher ->
        val matchResult = matcher.matchResult(lottoTickets, winningLotto, bonusNumber)
        val earnedRate = matcher.calculateEarnedRate(matchResult.earnedMoney, paidMoney)
        ResultView.showMatchResult(matchResult, earnedRate)
    }
}
