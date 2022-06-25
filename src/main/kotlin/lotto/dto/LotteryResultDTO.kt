package lotto.dto

import lotto.domain.LotterySet
import lotto.policy.LotteryPolicy

data class LotteryResultDTO(
    val autoLotteries: LotterySet,
    val manualLotteries: LotterySet,
    val LotteryPolicy: LotteryPolicy,
) {
    val lotteries
        get() =
            listOf(manualLotteries, autoLotteries)
                .flatten()
                .let(::LotterySet)
}
