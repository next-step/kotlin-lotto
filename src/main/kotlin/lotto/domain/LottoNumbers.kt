package lotto.domain

data class LottoNumbers(private val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) { INVALID_LOTTO_NUMBER_COUNT_MESSAGE }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return numbers.contains(lottoNumber)
    }

    override fun toString(): String {
        return numbers.joinToString(", ") { it.number.toString() }
    }

    fun checkLottoNumbersMatch(lottoNumbers: LottoNumbers): Int {
        return numbers.intersect(lottoNumbers.numbers).size
    }

    companion object {
        const val INVALID_LOTTO_NUMBER_COUNT_MESSAGE: String = "로또 번호는 6개여야 합니다"
        const val LOTTO_NUMBER_COUNT: Int = 6
    }
}
