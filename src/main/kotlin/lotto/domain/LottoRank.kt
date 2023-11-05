package lotto.domain

enum class LottoRank(
    val sameCount: Int,
    val amount: Int
) {
    FIRST_PLACE(6, 2000000000),
    SECOND_PLACE(5, 1500000),
    THIRD_PLACE(4, 50000),
    FOURTH_PLACE(3, 5000);

    companion object {
        fun of(sameCount: Int) = values().find { it.sameCount == sameCount }
    }
}
