package lotto.data

class LottoNumbers(
    numbers: List<Int>
) {
    private val values: List<LottoNumber> = numbers.map { LottoNumber.from(it) }

    init {
        require(values.size == LOTTO_NUMBERS_SIZE) { "로또 번호의 개수는 6개여야 합니다." }
        require(!hasDuplicatedNumber()) { "중복되는 숫자는 없어야 합니다." }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return values.contains(lottoNumber)
    }

    fun countMatchedNumber(targetLottoNumbers: LottoNumbers): Int {
        return values.count { targetLottoNumbers.contains(it) }
    }

    private fun hasDuplicatedNumber(): Boolean {
        return values.find(::isDuplicated) != null
    }

    private fun isDuplicated(lottoNumber: LottoNumber): Boolean {
        return values.count { it == lottoNumber } != COUNT_OF_UNIQUE_NUMBER
    }

    fun toIntList(): List<Int> =
        values.map { it.value }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
        private const val COUNT_OF_UNIQUE_NUMBER = 1
    }
}
