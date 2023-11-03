package lotto.domain

@JvmInline
value class LottoNumbers(val numbers: List<LottoNumber>) {

    init {
        validateLottoNumbers()
    }

    fun matchNumbersCount(otherNumbers: LottoNumbers): Int {
        return numbers.filter { otherNumbers.matchNumbers(it) }.size
    }

    fun matchNumbers(otherNumber: LottoNumber): Boolean {
        return numbers.contains(otherNumber)
    }

    override fun toString(): String {
        return PREFIX + numbers.joinToString(SEPARATOR) + SUFFIX
    }

    private fun validateLottoNumbers() {
        require(numbers.toSet().size == numbers.size) {
            "로또는 중복되지 않는 숫자만 가질 수 있습니다."
        }
    }

    companion object {
        private const val SEPARATOR = ", "
        private const val PREFIX = "["
        private const val SUFFIX = "]"
    }
}
