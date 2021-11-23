package lotto.domain

enum class Prize(val count: Int, val money: Money) {
    NONE(0, Money.of(0)),
    MATCH_THREE(3, Money.of(5_000)),
    MATCH_FOUR(4, Money.of(50_000)),
    MATCH_FIVE(5, Money.of(1_500_000)),
    MATCH_SIX(6, Money.of(2_000_000_000));

    companion object {
        fun of(count: Int) = values().find { it.count == count } ?: NONE
    }
}
