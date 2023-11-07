package lotto.domain

enum class Rank(val hitCount: Int, val prize: Long) {
    ThreeHit(3, 5_000),
    FourHit(4, 50_000),
    FiveHit(5, 1_500_000),
    SixHit(6, 2_000_000_000),
}
