package lotto

enum class RANKING(val winningCount: Int, val winningPrice: Int) {
    FOURTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000)
}
