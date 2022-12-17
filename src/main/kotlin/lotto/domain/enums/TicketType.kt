package lotto.domain.enums

import lotto.domain.policy.LotteryNumberAutoGenerateStrategy

enum class TicketType {
    AUTO;

    fun toGenerateStrategy(): LotteryNumberAutoGenerateStrategy {
        return when(this) {
            AUTO -> LotteryNumberAutoGenerateStrategy
        }
    }
}