package lotto.view.outputView

import lotto.domain.Lotto
import lotto.domain.LottoPrize
import lotto.domain.Money

interface OutputView {
    fun printLottoBuyResult(lottos: List<Lotto>)
    fun printLottoWinCheckResult(paidMoney: Money, prizes: List<LottoPrize>)
}
