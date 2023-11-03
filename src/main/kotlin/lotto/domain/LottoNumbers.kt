package lotto.domain

@JvmInline
value class LottoNumbers(val numbers: List<LottoNumber>) {

    init {
        validateLottoNumbers()
    }
    fun matchNumbers(otherNumbers: LottoNumbers): Int {
        return numbers.filter { otherNumbers.numbers.contains(it) }.size
    }

    private fun validateLottoNumbers() {
        require(numbers.toSet().size == numbers.size) {
            "로또는 중복되지 않는 숫자만 가질 수 있습니다."
        }
    }
}
