package lotto.domain

import lotto.view.ResultView
import lotto.view.View

class LottoController() {
    fun play() {
        val insertAmount = View.insertAmount()
        val lottoStore = LottoStore(insertAmount)
        View.purchasableLottoCount(lottoStore)
        val purchasedLotto = lottoStore.purchase()
        View.printPurchasedLottoList(purchasedLotto)

        val luckyNumber = View.getLuckyDrawNumber()
        val bonusNumber = View.getBonusNumber()
        val lottoDraw = LottoDraw(luckyNumber, bonusNumber)

        lottoDraw.draw(purchasedLotto)
        ResultView.getReport(lottoDraw)
        ResultView.getResult(lottoDraw, insertAmount)
    }
}
