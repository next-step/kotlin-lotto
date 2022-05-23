package lotto.view.input

import lotto.model.data.Lottos

interface ManualLottosInputView {
    fun readCountOfManualLotto(maxCount: Int): Int
    fun readManualLottos(count: Int): Lottos
}
