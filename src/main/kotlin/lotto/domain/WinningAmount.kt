package lotto.domain

enum class WinningAmount(
    private val matchCount: Int?,
    val amount: Int,
) {
    LOSING_TICKET(null, 0),
    FOURTH_PLACE(3, 5_000),
    THIRD_PLACE(4, 50_000),
    SECOND_PLACE(5, 1_500_000),
    FIRST_PLACE(6, 2_000_000_000);

    fun getMatchCount(): Int {
        return matchCount ?: 0
    }

    companion object {
        fun from(count: Int): WinningAmount {
            return values().find { it.matchCount == count } ?: LOSING_TICKET
        }
    }
}
