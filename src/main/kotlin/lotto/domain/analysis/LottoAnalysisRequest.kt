package lotto.domain.analysis

import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.shop.LottoGame
import math.PositiveNumber

data class LottoAnalysisRequest(
    val lottoGames: List<LottoGame>,
    val lottoPurchaseAmount: PositiveNumber,
    val lastWeekWinLottoNumbers: LottoNumbers,
)
