package lotto.domain

enum class Prize(
    private val value: Int,
    private val matcher: (Int) -> Boolean,
) {
    FIRST(2_000_000_000, { it == 6 }),
    SECOND(1_500_000, { it == 5 }),
    THIRD(50_000, { it == 4 }),
    FOURTH(5_000, { it == 3 }),
    NONE(0, { false }),
    ;

    companion object {
        fun calculate(count: Int) = entries.find { it.matcher(count) } ?: NONE
    }
}
