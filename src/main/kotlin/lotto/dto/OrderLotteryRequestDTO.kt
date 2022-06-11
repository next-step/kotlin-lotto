package lotto.dto

import lotto.vo.LotteryNumberSet
import lotto.vo.Money

data class OrderLotteryRequestDTO(val money: Money, val manualLotteryNumbers: List<LotteryNumberSet>)
