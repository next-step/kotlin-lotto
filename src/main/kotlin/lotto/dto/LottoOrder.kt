package lotto.dto

import lotto.domain.LotteryPaper

data class LottoOrder(val purchasingAmount: Int, val manualBuyLotteryPaper: List<LotteryPaper>)
