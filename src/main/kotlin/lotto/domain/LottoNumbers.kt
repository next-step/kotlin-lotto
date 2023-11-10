package lotto.domain

class LottoNumbers(
    private val values: List<LottoNumber>
) {

    init {
        validateCount()
        validateDuplication()
    }

    val sortedValues: List<LottoNumber> by lazy {
        values.sortedBy { it.value }
    }

    fun intersect(numbers: LottoNumbers): Set<LottoNumber> {
        return sortedValues.intersect(numbers.sortedValues.toSet())
    }

    private fun validateCount() {
        require(values.size == Lotto.LOTTO_NUMBER_COUNT) {
            "로또 번호는 ${Lotto.LOTTO_NUMBER_COUNT}개여야 합니다."
        }
    }

    private fun validateDuplication() {
        require(values.toSet().size == Lotto.LOTTO_NUMBER_COUNT) {
            "로또 번호는 중복되지 않아야 합니다."
        }
    }
}
