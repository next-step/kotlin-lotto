package lotto

import lotto.domain.LottoStore
import lotto.domain.model.LastWeekMatchLotto
import lotto.domain.model.LottoCash
import lotto.domain.model.LottoMatchResult
import lotto.domain.model.Rank
import lotto.domain.model.Rank.Companion.filterHasReward
import lotto.domain.model.Rank.Companion.sortedByReward
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
            } while (LottoStore.isNotPurchasable(lottoCash))

            val lottoNumbersByManual = InputView.readLottoNumbersByManual()
            val (lottosByManual, lottoCashForAuto) = LottoStore.purchaseLottosByManual(lottoCash, lottoNumbersByManual)
            val lottosByAuto = LottoStore.purchaseLottosByAuto(lottoCashForAuto)
            val lottos = lottosByManual + lottosByAuto
            ResultView.printPurchaseResult(lottosByManual.size, lottosByAuto.size, lottos)

            val (numbers, bonusNumber) = InputView.readLastWeekMatchNumbers()
            val lastWeekMatchLotto = LastWeekMatchLotto.valueOf(numbers, bonusNumber)

            val lottoMatchList = LottoStore.checkMatchResult(lottos, lastWeekMatchLotto)
            val rankList = Rank.values().filterHasReward().sortedByReward()
            ResultView.printLottoMatchResult(LottoMatchResult(lottoCash, lottoMatchList), rankList)
        }
    }
}
