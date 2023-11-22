package lotto.domain

enum class Rank(val hitCount: Int, val prize: Long) {
    LastPlace(0, 0),
    FourthPlace(3, 5_000),
    ThirdPlace(4, 50_000),
    SecondPlace(5, 1_500_000),
    FirstPlace(6, 2_000_000_000);

    companion object {
        fun ofCount(count: Int): Rank {
            return Rank.values().find { it.hitCount == count } ?: LastPlace
        }
    }
}
