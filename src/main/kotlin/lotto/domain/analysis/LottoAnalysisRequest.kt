package lotto.domain.analysis

import lotto.domain.lottonumber.WinLottoNumbers
import lotto.domain.shop.LottoGame
import math.PositiveNumber

data class LottoAnalysisRequest(
    val lottoGames: List<LottoGame>,
    val lottoPurchaseAmount: PositiveNumber,
    val lastWeekWinLottoNumbers: WinLottoNumbers,
)
