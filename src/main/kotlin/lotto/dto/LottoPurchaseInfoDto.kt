package lotto.dto

import lotto.domain.LottoPurchaseInfo

data class LottoPurchaseInfoDto(val autoLottoCount: Int, val manualLottoCount: Int) {
    constructor(lottoPurchaseInfo: LottoPurchaseInfo) : this(
        autoLottoCount = lottoPurchaseInfo.autoLottoCount,
        manualLottoCount = lottoPurchaseInfo.manualLottoCount
    )
}
