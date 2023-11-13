package lotto

import lotto.domain.Lotto
import lotto.domain.LottoCash
import lotto.domain.LottoMatchResult
import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cash = InputView.readCash()
            val lottoCash = LottoCash.valueOf(cash)
            val lottos = LottoStore.generateLottosByAuto(lottoCash)
            ResultView.printPurchaseResult(lottos)

            val lastWeekMatchNumbers = InputView.readLastWeekMatchNumbers()
            val lastWeekAllMatchLotto = Lotto.valueOf(lastWeekMatchNumbers)

            val lottoMatchList = LottoStore.checkMatchResult(lottos, lastWeekAllMatchLotto)
            ResultView.printMatchResult(LottoMatchResult(lottoCash, lottoMatchList))
        }
    }
}
