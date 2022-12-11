package lotto.domain

enum class Rank(
    val matches: Int,
    val prize: Int,
) {
    FIRST(
        matches = 3,
        prize = 5000,
    ),
    THIRD(
        matches = 4,
        prize = 50000,
    ),
    FOURTH(
        matches = 5,
        prize = 1500000,
    ),
    FIFTH(
        matches = 6,
        prize = 2000000000,
    );

    override fun toString(): String = "${matches}개 일치 (${prize}원)"
}
