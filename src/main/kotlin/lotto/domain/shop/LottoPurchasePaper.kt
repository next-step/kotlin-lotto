package lotto.domain.shop

import math.PositiveNumber

data class LottoPurchasePaper(
    val lottoPurchaseAmount: PositiveNumber,
    val selfSettingLottoNumbersPapers: List<SelfSettingLottoNumberPaper>,
) {

    fun autoPurchaseSize(lottoPrice: PositiveNumber): Int {
        return (lottoPurchaseAmount / lottoPrice).value - selfSettingLottoNumbersPapers.size
    }
}
