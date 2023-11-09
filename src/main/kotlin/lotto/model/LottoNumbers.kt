package lotto.model

class LottoNumbers(
    private val numbers: List<Int>
) {

    fun match(target: LottoNumbers): Int {
        val sourceLottoNumbers = this.getNumbers()
        val targetLottoNumbers = target.getNumbers().toSet()

        return sourceLottoNumbers
            .intersect(targetLottoNumbers)
            .size
    }

    private fun getNumbers(): List<Int> {
        return numbers
    }

    override fun toString(): String {
        return numbers.joinToString(LOTTO_NUMBERS_DELIMITER)
    }

    companion object {
        private const val LOTTO_NUMBERS_DELIMITER = ", "
    }
}
