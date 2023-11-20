package org.bmsk.domain.model.statistics

import org.bmsk.domain.model.lotto.LottoLottery

class LottoStatistics(
    val lottoTickets: List<LottoLottery>,
    val numberOfMatches3: Int,
    val numberOfMatches4: Int,
    val numberOfMatches5: Int,
    val numberOfMatches6: Int,
    val totalProfitRate: Double
)
