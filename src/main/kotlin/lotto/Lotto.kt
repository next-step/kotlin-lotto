package lotto

class Lotto {
    private val _lottoNumber = ArrayList<Int>()
    val lottoNumber
        get() = _lottoNumber

    fun getLottoNumber(lottoNumber: List<Int> = generateLottoNumber()) {
        _lottoNumber.clear()
        _lottoNumber.addAll(lottoNumber)
    }

    private fun generateLottoNumber(): List<Int> {
        return (LOTTO_START_NUMBER..LOTTO_END_NUMBER).shuffled().take(LOTTO_SIZE)
    }

    fun getCountWithWinningLotteryNumber(winningLottoNumbers: List<Int>): Int {
        return winningLottoNumbers.filter { number -> _lottoNumber.contains(number) }.size
    }

    fun exchangeMoney(count: Int): Int {
        return when (count) {
            THREE_COUNT -> THREE_COUNT_MONEY
            FOUR_COUNT -> FOUR_COUNT_MONEY
            FIVE_COUNT -> FIVE_COUNT_MONEY
            SIX_COUNT -> SIX_COUNT_MONEY
            else -> ELSE_COUNT_MONEY
        }
    }

    companion object {
        private const val LOTTO_START_NUMBER = 1
        private const val LOTTO_END_NUMBER = 45
        private const val LOTTO_SIZE = 6
        private const val THREE_COUNT = 3
        private const val FOUR_COUNT = 4
        private const val FIVE_COUNT = 5
        private const val SIX_COUNT = 6
        private const val THREE_COUNT_MONEY = 5000
        private const val FOUR_COUNT_MONEY = 50000
        private const val FIVE_COUNT_MONEY = 150000
        private const val SIX_COUNT_MONEY = 2000000000
        private const val ELSE_COUNT_MONEY = 0
    }
}
