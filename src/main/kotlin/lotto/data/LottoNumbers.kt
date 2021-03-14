package lotto.data

class LottoNumbers(
    numbers: List<Int>
) {
    private val lottoNumbers: List<LottoNumber> = numbers.map { LottoNumber.from(it) }

    init {
        require(lottoNumbers.size == LOTTO_NUMBERS_SIZE) { "로또 번호의 개수는 6개여야 합니다." }
        require(!hasDuplicatedNumber()) { "중복되는 숫자는 없어야 합니다." }
    }

    fun contains(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.contains(lottoNumber)
    }

    fun count(predicate: (LottoNumber) -> Boolean): Int {
        return lottoNumbers.count(predicate)
    }

    private fun hasDuplicatedNumber(): Boolean {
        return lottoNumbers.find(::isDuplicated) != null
    }

    private fun isDuplicated(lottoNumber: LottoNumber): Boolean {
        return lottoNumbers.count { it == lottoNumber } != COUNT_OF_UNIQUE_NUMBER
    }

    fun toIntList(): List<Int> =
        lottoNumbers.map { it.lottoNumber }

    companion object {
        private const val LOTTO_NUMBERS_SIZE = 6
        private const val COUNT_OF_UNIQUE_NUMBER = 1
    }
}
