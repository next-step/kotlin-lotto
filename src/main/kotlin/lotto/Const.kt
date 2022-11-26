package lotto

object Const {
    const val LOTTO_BASE_PRICE = 1000
    const val LOTTO_NUMBERS_COUNT = 6
    const val LOTTO_MIN_RANDOM_VALUE = 1
    const val LOTTO_MAX_RANDOM_VALUE = 45

    enum class RANKING(val winningCount: Int, val winningPrice: Int) {
        FOURTH(3, 5000), THIRD(4, 50000), SECOND(5, 1500000), FIRST(6, 2000000000)
    }
}
