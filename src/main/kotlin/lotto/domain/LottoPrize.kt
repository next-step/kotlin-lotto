package lotto.domain

enum class LottoPrize(val value: Int, val price: Int) {
    SIX_MATCH(6, 2000000000), FIVE_MATCH(5, 1500000),
    FOUR_MATCH(4, 50000), THREE_MATCH(3, 5000),
    NOT_MATCH(0, 0);

    companion object {
        fun from(value: Int): LottoPrize {
            return values().find { it.value == value } ?: NOT_MATCH
        }
    }
}
