package lotto

class Lotto {
    val numbers: List<Int>
        get() = _numbers
    private val _numbers = arrayListOf<Int>()

    fun processLotto(lottoNumbers: List<Int> = shuffled()) {
        _numbers.clear()
        _numbers.addAll(lottoNumbers)
    }

    fun getContainLottoNumberSameCount(winningNumbers: List<Int>): Int {
        var sameCount = 0
        winningNumbers.forEach { winningNumber ->
            if (isContainLottoNumber(winningNumber)) sameCount++
        }

        return sameCount
    }

    fun isContainLottoNumber(winningNumber: Int): Boolean = _numbers.contains(winningNumber)

    fun exchangeWinningMoney(sameCount: Int): Int {
        return when (sameCount) {
            FOURTH_WINNING_NUMBER_SAME_COUNT -> FOURTH_WINNING_MONEY
            else -> BLANK
        }
    }

    private fun shuffled(): List<Int> =
        List(LOTTO_NUMBER_COUNT) {
            (MIN_NUMBER..MAX_NUMBER).random()
        }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6

        const val FOURTH_WINNING_NUMBER_SAME_COUNT = 3

        const val FOURTH_WINNING_MONEY = 5000
        const val BLANK = 0
    }
}
