package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
) {
    FIRTH(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    DEFAULT(0, 0),
    ;

    companion object {
        fun of(matchCount: Int): LottoRank {
            return values().find { it.matchCount == matchCount } ?: DEFAULT
        }
    }
}
