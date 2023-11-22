package lotto.domain

enum class Rank(val hitCount: Int, val needBonusHit: Boolean, val prize: Long) {
    FirstPlace(6, false, 2_000_000_000),
    SecondPlace(5, true, 3_000_000),
    ThirdPlace(5, false, 1_500_000),
    FourthPlace(4, false, 50_000),
    FifthPlace(3, false, 5_000),
    LastPlace(0, false, 0);

    companion object {
        fun of(count: Int, bonusHit: Boolean): Rank {
            return Rank.values().find {
                it.hitCount == count && if (it.needBonusHit) bonusHit else true
            } ?: LastPlace
        }
    }
}
