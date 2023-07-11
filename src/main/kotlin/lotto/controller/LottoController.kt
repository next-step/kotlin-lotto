package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoShop
import lotto.domain.Lottos
import lotto.domain.PurchaseMoney
import lotto.domain.WinningLotto
import lotto.view.InputView

class LottoController {

    fun inputWinningLotto(): WinningLotto {
        return WinningLotto(Lotto(InputView.winningLotto()), LottoNumber.from(InputView.bonusNumber()))
    }

    fun purchaseLottos(): Pair<Lottos, PurchaseMoney> {
        val purchaseMoney = InputView.purchaseMoney()
        val manualLottoCount = InputView.manualLottoCount()
        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualPurchaseLottos = (1..manualLottoCount)
            .map { Lotto(InputView.manualLotto()) }
            .let { Lottos(it) }

        return Pair(LottoShop.purchase(purchaseMoney, manualPurchaseLottos), PurchaseMoney(purchaseMoney))
    }
}
