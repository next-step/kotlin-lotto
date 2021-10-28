package lotto.domain

enum class Match(val prize: Int) {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000)
}
