package lotto

enum class Rank(val rank: Int, val price: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOUR(3, 5_000),
}