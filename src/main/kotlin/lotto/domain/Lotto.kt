package lotto.domain

class Lotto {
    private val _lottoNumbers: LottoNumbers

    val lottoNumbers: LottoNumbers
        get() = _lottoNumbers

    init {
        _lottoNumbers = purchaseLotto()
    }

    private fun purchaseLotto(): LottoNumbers {
        val numbers = (START_LOTTO_NUMBER..LAST_LOTTO_NUMBER).shuffled()
            .subList(FROM_INDEX, TO_INDEX)
            .sorted()
        return LottoNumbers(numbers)
    }

    fun getMatchCount(lastWinningNumber: WinningNumbers): Int {
        return lottoNumbers.numbers.count { it in lastWinningNumber.numbers }
    }

    companion object {
        const val START_LOTTO_NUMBER = 1
        const val LAST_LOTTO_NUMBER = 45
        const val FROM_INDEX = 0
        const val TO_INDEX = 6
    }
}
