package lotto.domain

class Lotto(
    val lottoNumbers: LottoNumbers
) {
    init {
        require(lottoNumbers.numbers.size == LOTTO_DEFAULT_COUNT) {
            ERROR_LOTTO_COUNT
        }
        require(lottoNumbers.numbers.all { it in START_LOTTO_NUMBER..LAST_LOTTO_NUMBER }) {
            ERROR_LOTTO_NUMBER_RANGE
        }
    }

    fun purchaseAutoLotto(): LottoNumbers {
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
        const val ERROR_LOTTO_COUNT = "로또 개수는 6개여야 합니다."
        const val ERROR_LOTTO_NUMBER_RANGE = "로또 숫자는 1 부터 45 까지 입니다."
    }
}
