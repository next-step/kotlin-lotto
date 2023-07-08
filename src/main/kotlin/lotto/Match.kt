package lotto

enum class Match(
    private val count: Int,
    val winningAmount: Int
) {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    ;

    companion object {
        fun from(count: Int): Match? {
            return values().find { it.count == count }
        }
    }
}
