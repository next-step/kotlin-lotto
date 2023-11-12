package lotto.lotto

import lotto.ui.InputView

object LottoGenerator {
    fun createLottoList(inputCount: Int, lottoType: LottoType): List<Lotto> = (1..inputCount).map {
        when (lottoType) {
            LottoType.AUTO -> Lotto()
            LottoType.MANUAL -> Lotto(InputView.inputManualLotto().toLottoNumbers())
        }
    }
}
