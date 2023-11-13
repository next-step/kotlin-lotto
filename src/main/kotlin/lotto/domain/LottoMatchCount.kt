package lotto.domain

enum class LottoMatchCount(val reward: Int) {
    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000),
    ;
}
