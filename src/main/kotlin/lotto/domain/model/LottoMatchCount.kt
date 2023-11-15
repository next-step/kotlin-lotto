package lotto.domain.model

enum class LottoMatchCount(val reward: Int) {
    ZERO(0),
    ONE(0),
    TWO(0),
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000),
    ;

    companion object {
        fun from(matchCount: Int): LottoMatchCount = when (matchCount) {
            0 -> ZERO
            1 -> ONE
            2 -> TWO
            3 -> THREE
            4 -> FOUR
            5 -> FIVE
            6 -> SIX
            else -> throw IllegalArgumentException("로또 숫자의 일치 수는 로또 숫자 수의 범위를 벗어날 수 없습니다.")
        }
    }
}
