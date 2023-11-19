package lotto.domain

enum class LottoPrize(
    val matchCount: Int,
    val prizeMoney: Long
) {

    FIRST(6, 2_000_000_000L),
    SECOND(5, 1_500_000L),
    THIRD(4, 50_000L),
    FOURTH(3, 5_000L),
    ;
}
