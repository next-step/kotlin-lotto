package lotto.view.result

import lotto.domain.LottoPurchaseCount
import lotto.domain.LottoTicket

class ConsoleResultView : ResultView {
    override fun showPurchaseCount(purchaseCount: LottoPurchaseCount) {
        println("${purchaseCount.value}개를 구매했습니다.")
    }

    override fun showLottoTicketNumber(lottoTicket: LottoTicket) {
        lottoTicket.lottoPackages.forEach { println(it.getSortedNumbers()) }
    }
}
