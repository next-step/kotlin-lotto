package lotto.domain

class Lotto(
    val numbers: List<Int>
) {

    init {
        validateCount()
        validateDuplication()
        numbers.sorted()
    }

    private fun validateCount() {
        require(numbers.size == LOTTO_COUNT) {
            "로또 번호는 ${LOTTO_COUNT}개여야 합니다."
        }
    }

    private fun validateDuplication() {
        require(numbers.toSet().size == LOTTO_COUNT) {
            "로또 번호는 중복되지 않아야 합니다."
        }
    }

    companion object {
        const val LOTTO_COUNT = 6
    }
}

fun Lotto.matchCount(other: Lotto): Int {
    return numbers.intersect(other.numbers.toSet()).size
}
