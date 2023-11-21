package lotto.domain

import lotto.error.InvalidLottoNumberException

@JvmInline
value class LottoNumber(
    val value: List<Int>,
) {
    infix fun contains(number: Number): Boolean =
        value.contains(number)

    infix fun countMatched(other: LottoNumber) =
        value.count { other contains it }

    companion object {
        const val COUNT = 6
        val RANGE = 1..45

        fun of(numbers: List<Int>): LottoNumber {
            checkCount(numbers)
            checkUniqueNumbers(numbers)
            checkNumbersRange(numbers)
            return LottoNumber(numbers.sorted())
        }

        fun checkCanInclude(number: Int): Int {
            checkNotBelowMinimum(number)
            checkNotOverMaximum(number)
            return number
        }

        private fun checkCount(numbers: List<Int>) {
            require(numbers.count() == COUNT) { throw InvalidLottoNumberException("로또 번호 개수는 ${COUNT}여야 합니다") }
        }

        private fun checkUniqueNumbers(numbers: List<Int>) {
            require(
                numbers.count() == numbers.distinct().count()
            ) { throw InvalidLottoNumberException("로또 번호는 각기 다른 숫자여야 합니다") }
        }

        private fun checkNumbersRange(numbers: List<Int>) {
            checkNotBelowMinimum(numbers.min())
            checkNotOverMaximum(numbers.max())
        }

        private fun checkNotBelowMinimum(number: Int) {
            require(number >= RANGE.first) { throw InvalidLottoNumberException("로또 번호는 최소 수가 ${RANGE.first} 이상이여야 합니다") }
        }

        private fun checkNotOverMaximum(number: Int) {
            require(number <= RANGE.last) { throw InvalidLottoNumberException("로또 번호는 최대 수가 ${RANGE.last} 이하여야 합니다") }
        }
    }
}
