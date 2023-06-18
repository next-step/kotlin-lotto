package lotto.domain.analysis

import common.PositiveNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.shop.LottoGame

data class LottoAnalysisRequest(
    val lottoGames: List<LottoGame>,
    val lottoPurchaseAmount: PositiveNumber,
    val lastWeekWinLottoNumbers: LottoNumbers,
)
