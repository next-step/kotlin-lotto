package lotto.controller

import lotto.domain.Lotto
import lotto.view.InputView

class LottoController {
    fun inputPurchaseMoney(): Long {
        return InputView.purchaseMoney()
    }

    fun inputWinningLotto(): Lotto {
        return Lotto(InputView.winningLotto())
    }

    fun inputBonusNumber(): Int {
        return InputView.bonusNumber()
    }
}
