package lotto.money

import calculator.parseToInt

data class Money(
    private val value: Int
) {
    constructor(input: String) : this(parseToInt(input))

    companion object {
        fun of(value: Int): Money {
            return Money(value)
        }
    }
}
