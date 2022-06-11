package lotto.dto

import lotto.policy.LotteryPolicy
import lotto.vo.LotterySet

data class LotteryResultDTO(
    val autoLotteries: LotterySet,
    val manualLotteries: LotterySet,
    val LotteryPolicy: LotteryPolicy,
) {
    val lotteries: LotterySet by lazy {
        listOf(manualLotteries, autoLotteries).flatten().let(::LotterySet)
    }
}
