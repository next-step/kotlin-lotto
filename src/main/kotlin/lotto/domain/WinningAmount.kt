package lotto.domain

enum class WinningAmount(
    private val count: Int,
    val amount: Int,
) {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    companion object {
        fun from(count: Int): WinningAmount {
            return values().find { it.count == count }
                ?: throw IllegalArgumentException("맞은 개수는 0에서 6사이의 값이어야 해요")
        }
    }
}
