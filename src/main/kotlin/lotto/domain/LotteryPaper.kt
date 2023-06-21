package lotto.domain

class LotteryPaper(val lottoNumber: List<Int>) {
    companion object {
        const val MINIMUM_NUMBER = 1
        const val MAXIMUM_NUMBER = 45
        const val NUMBER_OF_LOTTO_DRAWS = 6
    }
}
