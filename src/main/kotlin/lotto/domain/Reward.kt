package lotto.domain

class Reward(val matchingCount: Int = 0, val reward: Int = 0) {

    companion object {
        const val FIRST_WIN_PRICE = 2_000_000_000
        const val SECOND_WIN_PRICE = 1_500_000
        const val THIRD_WIN_PRICE = 50_000
        const val FOURTH_WIN_PRICE = 5_000
    }
}