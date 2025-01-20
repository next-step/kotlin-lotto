package lotto.domain

enum class Prize(val money: Int, val count: Int) {
    FIRST(2_000_000_000, 6),
    SECOND(30_000_000, 5),
    THIRD(1_500_000, 5),
    FOURTH(50_000, 4),
    FIFTH(5_000, 3),
    NONE(0, 0),
    ;

    companion object {
        fun of(matchCount: Int, bonusLottoNumber: LottoNumber, lotto: Lotto) = when (matchCount) {
            6 -> FIRST
            5 -> if (bonusLottoNumber in lotto) SECOND else THIRD
            4 -> FOURTH
            3 -> FIFTH
            else -> NONE
        }
    }
}
