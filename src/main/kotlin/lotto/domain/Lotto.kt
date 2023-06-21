package lotto.domain

class Lotto {
    private val _lottoNumbers: List<Int>

    val lottoNumbers: List<Int>
        get() = _lottoNumbers

    init {
        _lottoNumbers = purchaseLotto()
    }

    private fun purchaseLotto(): List<Int> {
        return (START_LOTTO_NUMBER..LAST_LOTTO_NUMBER).shuffled()
            .subList(FROM_INDEX, TO_INDEX)
            .sorted()
    }

    fun getMatchCount(lastWinningNumber: List<Int>): Int {
        return lottoNumbers.count { it in lastWinningNumber }
    }

    companion object {
        const val START_LOTTO_NUMBER = 1
        const val LAST_LOTTO_NUMBER = 45
        const val FROM_INDEX = 0
        const val TO_INDEX = 6
    }
}
