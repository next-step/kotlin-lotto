package lotto.domain

enum class LottoRank(val containCount: Int, val money: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun of(containCount: Int, matchBonus: Boolean): LottoRank =
            when (containCount) {
                3 -> FIFTH
                4 -> FOURTH
                5 -> {
                    if (matchBonus) SECOND
                    else THIRD
                }
                6 -> FIRST
                else -> NONE
            }
    }
}
