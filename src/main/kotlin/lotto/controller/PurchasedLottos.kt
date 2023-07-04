package lotto.controller

import lotto.domain.LottoNumbers

data class PurchasedLottos(
    val manualLottos: List<LottoNumbers>,
    val automaticLottos: List<LottoNumbers>,
) {
    val allLottos: List<LottoNumbers> = manualLottos + automaticLottos
}
