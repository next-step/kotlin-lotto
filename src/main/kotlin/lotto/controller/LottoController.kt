package lotto.controller

import lotto.controller.dto.LottoData
import lotto.domain.Lottos
import lotto.domain.PurchasedMoney
import lotto.domain.getAutoLotto
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {
    fun handle() {
        val purchasedMoney = PurchasedMoney(InputView.inputPurchasedMoney())
        val lottoNumber = purchasedMoney.calculateLottoNumber().also { ResultView.printPurchasedLottoNumber(it) }
        Lottos.generateAutoLottos(lottoNumber) { getAutoLotto() }
            .also { ResultView.printLottos(it.toLottoDatas()) }
    }
}

fun Lottos.toLottoDatas(): List<LottoData> = this.lottos.map { LottoData.of(it) }
