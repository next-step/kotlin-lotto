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
        val lottoLuckyDraw = LottoLuckyDraw(luckyNumber, bonusNumber)
        val lottoDrawResult = LottoDrawResult(lottoLuckyDraw.luckyNumber, lottoLuckyDraw.bonusNumber)

        lottoDrawResult.draw(purchasedLotto)
        ResultView.getReport(lottoDrawResult)
        ResultView.getResult(lottoDrawResult, insertAmount)
    }
}
