package lotto

import lotto.domain.LottoStore
import lotto.domain.model.Lotto
import lotto.domain.model.LottoCash
import lotto.domain.model.LottoMatchResult
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val cash = InputView.readCash()
            val lottoCash = LottoCash(cash)
            val lottos = LottoStore.generateLottosByAuto(lottoCash)
            ResultView.printPurchaseResult(lottos)

            val lastWeekMatchNumbers = InputView.readLastWeekMatchNumbers()
            val lastWeekAllMatchLotto = Lotto.valueOf(lastWeekMatchNumbers)

            val lottoMatchList = LottoStore.checkMatchResult(lottos, lastWeekAllMatchLotto)
            ResultView.printMatchResult(LottoMatchResult(lottoCash, lottoMatchList))
        }
    }
}
