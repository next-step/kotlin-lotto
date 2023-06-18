package lotto.controller

import lotto.domain.LottoNumbers

data class PurchasedLottoNumbers(
    val manualLottoList: List<LottoNumbers>,
    val automaticLottoList: List<LottoNumbers>,
) {
    val allLottoList: List<LottoNumbers> = manualLottoList + automaticLottoList
}