package lotto

import lotto.domain.LottoStore
import lotto.domain.model.LastWeekMatchLotto
import lotto.domain.model.LottoCash
import lotto.domain.model.LottoMatchResult
import lotto.domain.model.Rank
import lotto.view.InputView
import lotto.view.ResultView

class LottoApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            var lottoCash: LottoCash
            do {
                val cash = InputView.readCash()
                lottoCash = LottoCash(cash)
            } while (!LottoStore.isPurchasable(lottoCash))
            val lottos = LottoStore.purchaseLottosByAuto(lottoCash)
            ResultView.printPurchaseResult(lottos)

            val (numbers, bonusNumber) = InputView.readLastWeekMatchNumbers()
            val lastWeekMatchLotto = LastWeekMatchLotto.valueOf(numbers, bonusNumber)

            val lottoMatchList = LottoStore.checkMatchResult(lottos, lastWeekMatchLotto)
            val rankList = Rank.values().filter { it.reward > 0 }.sortedBy { it.reward }
            ResultView.printLottoMatchResult(LottoMatchResult(lottoCash, lottoMatchList), rankList)
        }
    }
}
