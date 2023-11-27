package lotto.domain

enum class Rank(val hitCount: Int, val needBonusHit: Boolean = false, val prize: Long) {
    FirstPlace(hitCount = 6, prize = 2_000_000_000),
    SecondPlace(hitCount = 5, needBonusHit = true, prize = 3_000_000),
    ThirdPlace(hitCount = 5, prize = 1_500_000),
    FourthPlace(hitCount = 4, prize = 50_000),
    FifthPlace(hitCount = 3, prize = 5_000),
    LastPlace(hitCount = 0, prize = 0);

    companion object {
        fun of(count: Int, bonusHit: Boolean): Rank {
            return Rank.values().find {
                it.hitCount == count && if (it.needBonusHit) bonusHit else true
            } ?: LastPlace
        }
    }
}
