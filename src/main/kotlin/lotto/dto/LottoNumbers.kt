package lotto.dto

data class LottoNumbers(
    val numbers: List<Int>
) {
    init {
        require(numbers.size == 6)
        numbers.forEach { require(it in LOTTO_NUMBER_RANGE) }
        require(numbers.toSet().size == 6)
    }

    fun compareLottoNumbers(lottoNumbers: LottoNumbers): Int {
        return numbers.intersect(lottoNumbers.numbers.toSet()).count()
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
