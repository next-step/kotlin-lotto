package lotto

import lotto.views.Input.getManualLottoNumbers

object LottoManualService {

    fun generate(count: Int): List<LottoNumbers> {
        return getManualLottoNumbers(count)
    }
}
