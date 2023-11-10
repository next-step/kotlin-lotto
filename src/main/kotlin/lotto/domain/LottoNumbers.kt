package lotto.domain

class LottoNumbers(
    private val values: List<LottoNumber>
) {

    init {
        validateCount()
        validateDuplication()
    }

    val sortedValues: List<LottoNumber> =
        values.sortedBy { it.value }

    fun intersect(numbers: LottoNumbers) =
        values.intersect(numbers.values.toSet())

    fun contains(number: LottoNumber) =
        values.contains(number)

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
