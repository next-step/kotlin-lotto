package lotto

enum class LottoMatch(val count: Int, val reward: Long) {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000)
}
