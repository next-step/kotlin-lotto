package lotto.domain

enum class LottoRank(
    val sameCount: Int,
    val amount: Int
) {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 1_500_000),
    THIRD_PLACE(4, 50_000),
    FOURTH_PLACE(3, 5_000);

    companion object {
        fun of(sameCount: Int) = values().find { it.sameCount == sameCount }
    }
}
