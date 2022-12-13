package lotto.domain

enum class Rank(
    val matches: Int,
    val prize: Int,
) {
    FIFTH(
        matches = 3,
        prize = 5000,
    ),
    FOURTH(
        matches = 4,
        prize = 50000,
    ),
    THIRD(
        matches = 5,
        prize = 1500000,
    ),
    FIRST(
        matches = 6,
        prize = 2000000000,
    );

    override fun toString(): String = "${matches}개 일치 (${prize}원)"
}
