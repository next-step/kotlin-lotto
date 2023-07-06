package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
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
        return Lotto(LottoNumbers(InputView.manualLotto()))
    }

    fun inputWinningLotto(): WinningLotto {
        return WinningLotto(LottoNumbers(InputView.winningLotto()), InputView.bonusNumber())
    }
}
