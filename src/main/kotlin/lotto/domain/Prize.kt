package lotto.domain

enum class Prize(
    val matchCount: Int,
    val money: Long
) {

    THREE_MATCHED(3, 5_000),
    FOUR_MATCHED(4, 50_000),
    FIVE_MATCHED(5, 1_500_000),
    SIX_MATCHED(6, 2_000_000_000);

    companion object {
        fun all(): List<Prize> = values().toList()
    }
}
