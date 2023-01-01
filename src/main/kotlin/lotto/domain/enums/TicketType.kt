package lotto.domain.enums

import lotto.domain.policy.LotteryNumberAutoGenerateStrategy
import lotto.domain.policy.LotteryNumberManualGenerateStrategy
import lotto.domain.policy.LotteryNumbersGenerateStrategy
import lotto.domain.vo.LotteryNumbers

enum class TicketType {
    AUTO, MANUAL;

    fun toGenerateStrategy(lotteryNumbers: LotteryNumbers? = null): LotteryNumbersGenerateStrategy {
        return when (this) {
            AUTO -> LotteryNumberAutoGenerateStrategy
            MANUAL -> lotteryNumbers?.let { LotteryNumberManualGenerateStrategy(lotteryNumbers) }
                ?: throw IllegalArgumentException("수동 로또는 입력 번호가 있어야 합니다.")
        }
    }
}
