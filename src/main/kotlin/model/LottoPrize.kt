package model

enum class LottoPrize(val grade: Int, val prizeMoney: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000)
}
