package Lotto.domain

enum class LottoRank(val prizeMoney: Int) {
    FIRST(2_000_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    LOSE(0)
}