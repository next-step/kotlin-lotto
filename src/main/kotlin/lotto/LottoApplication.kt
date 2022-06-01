package lotto

import lotto.domain.LottoShop
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    val money = InputView.getPurchaseAmount()
    val lottoTickets = LottoShop().buyLotto(money)
    ResultView.showLottoInfo(lottoTickets)
    val winningNumbers = InputView.getWinningNumbers()
}
