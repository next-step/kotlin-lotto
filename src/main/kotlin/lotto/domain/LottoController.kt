package lotto.domain

import lotto.view.ResultView
import lotto.view.View

class LottoController() {
    fun execute() {
        val insertAmount = View.insertAmount()
        val lottoStore = LottoStore(insertAmount)
        View.printAbleToPurchaseLottoCount(lottoStore)
        val purchasedLotto = lottoStore.purchase()
        View.printPurchasedLottoList(purchasedLotto)

        val lottoLuckyDraw = LottoLuckyDraw(View.getLuckyDrawNumber())
        val lottoDrawResult = LottoDrawResult(lottoLuckyDraw.luckyNumber)

        lottoDrawResult.draw(purchasedLotto)
        ResultView.getReport(lottoDrawResult)
        ResultView.getResult(lottoDrawResult, insertAmount)
    }
}
