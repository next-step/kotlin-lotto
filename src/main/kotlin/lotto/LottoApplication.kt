package lotto

import lotto.domain.lotto.BonusNumber
import lotto.domain.lotto.ManualLottoTotal
import lotto.domain.lotto.ManualLottos
import lotto.domain.lotto.WinningLotto
import lotto.domain.matcher.LottoMatcher
import lotto.domain.money.PaidMoney
import lotto.domain.shop.LottoShop
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
