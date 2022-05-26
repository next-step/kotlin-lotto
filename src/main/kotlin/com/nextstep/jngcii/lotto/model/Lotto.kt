package com.nextstep.jngcii.lotto.model

class Lotto(_numbers: List<Int>) {
    val numbers: List<Int>

    init {
        validateCount(_numbers)
        validateDuplication(_numbers)
        validateRange(_numbers)

        numbers = _numbers.sorted()
    }

    fun getSameCount(comparison: Lotto): Int {
        var sameCount = INITIAL_COUNT

        numbers.forEach {
            sameCount += it.isIn(comparison.numbers)
        }

        return sameCount
    }

    private fun Int.isIn(comparison: List<Int>): Int {
        return if (this in comparison) {
            TRUE_COUNT
        } else {
            FALSE_COUNT
        }
    }

    private fun validateCount(numbers: List<Int>) {
        require(numbers.size == LOTTO_SIZE) { "${LOTTO_SIZE}개의 숫자가 아닙니다." }
    }

    private fun validateDuplication(numbers: List<Int>) {
        val distinctNumbers = numbers.distinct()
        require(distinctNumbers.size == numbers.size) { "각기 다른 6개의 숫자가 아닙니다." }
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
        private const val INITIAL_COUNT = 0
        private const val TRUE_COUNT = 1
        private const val FALSE_COUNT = 0
    }
}
