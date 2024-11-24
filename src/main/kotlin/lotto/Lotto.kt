package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoNumberCount()
        validateLottoNumber()
    }

    private fun validateLottoNumberCount() {
        if (numbers.size != LottoPolicy.LOTTO_NUMBER_COUNT) {
            throw InvalidLottoNumberCountException(numbers)
        }
    }

    private fun validateLottoNumber() {
        val invalidNumberCount =
            numbers.count { number ->
                number < LottoPolicy.MIN_LOTTO_NUMBER || number > LottoPolicy.MAX_LOTTO_NUMBER
            }

        if (invalidNumberCount != 0) {
            throw InvalidLottoNumberException(numbers)
        }
    }

    fun calculateMatchCount(winningNumbers: WinningNumbers): Int {
        return numbers.count { number -> winningNumbers.contains(number) }
    }
}
