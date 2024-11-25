package lotto.view.result

import lotto.view.dto.lotto.LottoPurchaseCountDto

object BuyResultView {
    fun print(dto: LottoPurchaseCountDto) {
        println("수동으로 ${dto.manualLottoAmount}장, 자동으로 ${dto.autoLottoAmount}개를 구매했습니다.")
    }
}
