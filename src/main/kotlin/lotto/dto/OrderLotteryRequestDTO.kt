package lotto.dto

import lotto.domain.LotteryNumberSet
import lotto.vo.Money

data class OrderLotteryRequestDTO(
    val money: Money,
    val manualLotteryNumbers: List<LotteryNumberSet>,
    val autoLotteryCount: Int,
)
