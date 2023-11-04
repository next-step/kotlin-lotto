package lotto.domain

enum class Prize(
    val matchedNumberCount: Int,
    val winningAmount: Long,
) {
    FIRST(6, 2000000000L),
    SECOND(5, 1500000L),
    THIRD(4, 50000L),
    FOURTH(3, 5000L),
    ;

    companion object {
        fun valueOfOrNull(matchedNumberCount: Int): Prize? {
            return Prize.values()
                .find { it.matchedNumberCount == matchedNumberCount }
        }
    }
}
