package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        if (numbers.size != LottoPolicy.LOTTO_NUMBER_COUNT) {
            throw InvalidLottoNumberCountException(numbers)
        }

        val invalidNumberCount = numbers.count { number -> number < LottoPolicy.MIN_LOTTO_NUMBER || number > LottoPolicy.MAX_LOTTO_NUMBER }
        if (invalidNumberCount != 0) {
            throw InvalidLottoNumberException(numbers)
        }
    }
}
