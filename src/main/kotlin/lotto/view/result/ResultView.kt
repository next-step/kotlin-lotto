package lotto.view.result

import lotto.domain.LottoPurchaseCount
import lotto.domain.LottoResultRank
import lotto.domain.LottoTicket
import java.math.BigDecimal

interface ResultView {
    fun showPurchaseCount(purchaseCount: LottoPurchaseCount)
    fun showLottoTicketNumber(lottoTicket: LottoTicket)
    fun showResultStatistics(resultStatistics: Map<LottoResultRank, Int>, totalProfitRate: BigDecimal)
}
