package lotto.domain.model

enum class LottoMatchCount(private val matchCount: Int, val reward: Int) {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    ;

    companion object {
        fun from(matchCount: Int): LottoMatchCount = values().find { it.matchCount == matchCount }
            ?: throw IllegalArgumentException("로또 숫자의 일치 수는 로또 숫자 수의 범위를 벗어날 수 없습니다. matchCount=$matchCount")
    }
}
