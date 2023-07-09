package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoShop
import lotto.domain.Lottos
import lotto.domain.PurchaseMoney
import lotto.domain.WinningLotto
import lotto.view.InputView

class LottoController {
    fun inputPurchaseMoney(): Long {
        return InputView.purchaseMoney()
    }

    fun inputManualLottoCount(): Int {
        return InputView.manualLottoCount()
    }

    fun inputManualLotto(): Lotto {
        return Lotto(InputView.manualLotto())
    }

    fun inputWinningLotto(): WinningLotto {
        return WinningLotto(Lotto(InputView.winningLotto()), InputView.bonusNumber())
    }

    fun purchaseLottos(): Pair<Lottos, PurchaseMoney> {
        val purchaseMoney = inputPurchaseMoney()
        val manualLottoCount = inputManualLottoCount()
        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualPurchaseLottos = (1..manualLottoCount)
            .map { inputManualLotto() }
            .let { Lottos(it) }

        return Pair(LottoShop.purchase(purchaseMoney, manualPurchaseLottos), PurchaseMoney(purchaseMoney))
    }
}
