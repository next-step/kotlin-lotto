package lotto.collection

enum class Prize(
    val matched: Int, val prize: Int
) {
    First(6, 2000000000),
    Second(5, 1500000),
    Third(5, 50000),
    Fourth(4, 5000);

    companion object {
        fun getPrizePerMatch(matched: Int): Int = values().find { it.matched == matched }?.prize ?: 0
    }
}
