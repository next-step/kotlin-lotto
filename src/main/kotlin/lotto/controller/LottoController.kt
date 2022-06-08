package lotto.controller

import lotto.controller.dto.LottoData
import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.PurchasedMoney
import lotto.domain.WinningLotto
import lotto.domain.getAutoLotto
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun handle() {
        val purchasedMoney = PurchasedMoney(InputView.inputPurchasedMoney())
        val lottoNumber = purchasedMoney.calculateLottoNumber().also { ResultView.printPurchasedLottoNumber(it) }
        val lottos = Lottos.generateAutoLottos(lottoNumber) { getAutoLotto() }
            .also { ResultView.printLottos(it.toLottoDatas()) }
        val winningLotto = InputView.inputWinningLotto().toWinningLotto()
    }
}

fun Lottos.toLottoDatas(): List<LottoData> = this.lottos.map { LottoData.of(it) }

fun List<Int>.toWinningLotto(): WinningLotto {
    val lotto = Lotto(this.map { LottoNumber.valueOf(it) })
    return WinningLotto(lotto)
}
