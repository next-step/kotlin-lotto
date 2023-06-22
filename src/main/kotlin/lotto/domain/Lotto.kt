package lotto.domain

class Lotto {
    private val _lottoNumbers: LottoNumbers

    val lottoNumbers: LottoNumbers
        get() = _lottoNumbers

    init {
        _lottoNumbers = purchaseLotto()
        require(lottoNumbers.numbers.size == LOTTO_DEFAULT_COUNT) {
            "로또 개수는 6개여야 합니다."
        }
        require(lottoNumbers.numbers.all { it in START_LOTTO_NUMBER..LAST_LOTTO_NUMBER }) {
            "로또 숫자는 1 부터 45 까지 입니다."
        }
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

    fun getBonusMatch(bonusNumber: Int): Boolean {
        return lottoNumbers.numbers.contains(bonusNumber)
    }

    companion object {
        const val START_LOTTO_NUMBER = 1
        const val LAST_LOTTO_NUMBER = 45
        const val FROM_INDEX = 0
        const val TO_INDEX = 6
        const val LOTTO_DEFAULT_COUNT = 6
    }
}
