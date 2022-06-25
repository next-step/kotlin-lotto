package lotto.dto

import lotto.domain.LotteryNumberSet

data class LotterySellDTO(val manualLotteryNumberSet: List<LotteryNumberSet>, val autoLotteryCount: Int)
