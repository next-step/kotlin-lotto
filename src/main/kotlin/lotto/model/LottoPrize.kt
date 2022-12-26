package lotto.model

enum class LottoPrize(val matchCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5000),
    ;

    companion object {
        fun of(matchCount: Int): LottoPrize {
            return values().find { it.matchCount == matchCount } ?: throw IllegalArgumentException("일치하는 등수가 없습니다.")
        }
    }
}
