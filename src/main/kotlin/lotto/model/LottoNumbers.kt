package lotto.model

class LottoNumbers(
    private val numbers: List<Int>
) {

    fun match(target: LottoNumbers): Int {
        val sourceLottoNumbers = numbers
        val targetLottoNumbers = target.numbers.toSet()

        return sourceLottoNumbers
            .intersect(targetLottoNumbers)
            .size
    }

    override fun toString(): String {
        return numbers.joinToString(LOTTO_NUMBERS_DELIMITER)
    }

    companion object {
        private const val LOTTO_NUMBERS_DELIMITER = ", "
    }
}
