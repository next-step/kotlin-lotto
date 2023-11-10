package lotto.domain

class Lotto(
    val numbers: List<LottoNumber>,
) {

    init {
        validateCount()
        validateDuplication()
        numbers.sortedBy { it.value }
    }

    fun calculateMatchCount(other: Lotto): Int {
        return numbers.intersect(other.numbers.toSet()).size
    }

    private fun validateCount() {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 ${LOTTO_NUMBER_COUNT}개여야 합니다."
        }
    }

    private fun validateDuplication() {
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT) {
            "로또 번호는 중복되지 않아야 합니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE = 1000
    }
}
