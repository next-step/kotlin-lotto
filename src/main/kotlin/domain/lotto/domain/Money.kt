package domain.lotto.domain

import domain.lotto.error.InvalidMoneyRangeException

@JvmInline
value class Money(private val money: Int = DEFAULT_MONEY) {
    init {
        if (money < DEFAULT_MONEY) {
            throw InvalidMoneyRangeException(money)
        }
    }

    companion object {
        private const val DEFAULT_MONEY = 0
    }
}
