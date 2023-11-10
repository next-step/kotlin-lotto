package lotto.lotto_manual

import lotto.lotto.Lotto
import lotto.lotto.toLottoNumbers
import lotto.ui.InputView

object LottoManual {
    fun createManualLottoList(inputManualCount: Int) =
        (1..inputManualCount).map { Lotto(InputView.inputManualLotto().toLottoNumbers()) }
}
