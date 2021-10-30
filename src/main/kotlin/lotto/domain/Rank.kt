package lotto.domain

enum class Rank(
    val reward: Long,
) {
    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FOURTH(5000),
    BLANK(0),
}
