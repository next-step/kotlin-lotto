package lotto.domain

enum class Price(val winningPrize: Int) {
    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FOURTH(5000),
    NONE(0)
}
