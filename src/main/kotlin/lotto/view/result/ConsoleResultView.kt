package lotto.view.result

import lotto.domain.LottoPurchaseCount

class ConsoleResultView : ResultView {
    override fun showPurchaseCount(purchaseCount: LottoPurchaseCount) {
        println("${purchaseCount.value}개를 구매했습니다.")
    }
}
