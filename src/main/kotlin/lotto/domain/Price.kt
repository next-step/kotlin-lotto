package lotto.domain

enum class Price(val winningPrize: Int) {
    FIRST(2_000_000_000),
    SECOND(1_500_000),
    THIRD(50_000),
    FOURTH(5_000),
    NONE(0)
}
