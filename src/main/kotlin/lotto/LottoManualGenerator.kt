package lotto

import lotto.views.Input.getManualLottoNumbers

class LottoManualGenerator : LottoGeneratorStrategy {

    override fun generate(count: Int): List<LottoNumbers> {
        return getManualLottoNumbers(count)
    }
}
