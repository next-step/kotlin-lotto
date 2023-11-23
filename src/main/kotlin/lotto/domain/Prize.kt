package lotto.domain

enum class Prize(val needToBeMatched: Int, val award: Money) {
    FIRST_PRIZE(6, Money(2000000000)),
    SECOND_PRIZE(5, Money(1500000)),
    THIRD_PRIZE(4, Money(50000)),
    FOURTH_PRIZE(3, Money(5000)),
    NONE(0, Money(0)),
    ;

    companion object {
        fun of(amountOfNumberMatched: Int): Prize =
            values().find { it.needToBeMatched == amountOfNumberMatched } ?: NONE
    }
}
