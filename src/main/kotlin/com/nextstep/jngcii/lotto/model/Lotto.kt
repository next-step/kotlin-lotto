package com.nextstep.jngcii.lotto.model

class Lotto(_numbers: List<Int>) {
    val numbers: Set<Int>

    init {
        validateCount(_numbers)
        validateRange(_numbers)

        numbers = _numbers.toSortedSet()
    }

    fun getSameCount(comparison: Lotto): Int {
        return numbers.intersect(comparison.numbers).count()
    }

    private fun validateCount(numbers: List<Int>) {
        require(numbers.size == LOTTO_SIZE) { "${LOTTO_SIZE}개의 숫자가 아닙니다." }
    }

    private fun validateRange(numbers: List<Int>) {
        numbers.forEach {
            require(it in MINIMAL_NUMBER..MAXIMAL_NUMBER) { "$MINIMAL_NUMBER~${MAXIMAL_NUMBER}에 해당하는 숫자로 이루어진 리스여야합니다." }
        }
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val MINIMAL_NUMBER = 1
        private const val MAXIMAL_NUMBER = 45
    }
}
