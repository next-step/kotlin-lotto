package step2

import java.lang.IllegalArgumentException

class LottoNumber private constructor(
    private var numbers: List<Int> = emptyList(),
) {
    val value: List<Int>
        get() = numbers

    private fun autoGenerate() {
        this.numbers = LOTTO_NUMBER_RANGE.shuffled().take(LOTTO_NUMBER_COUNT)
    }

    fun matchCount(other: LottoNumber): Int {
        return this.value.count { other.value.contains(it) }
    }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
        private val LOTTO_NUMBER_RANGE = 1..45

        fun buildAuto(): LottoNumber {
            return LottoNumber().apply {
                this.autoGenerate()
            }
        }

        fun from(numbers: List<Int>): LottoNumber {
            if (numbers.size != LOTTO_NUMBER_COUNT) {
                throw IllegalArgumentException("로또 번호는 6개여야 합니다.")
            }
            if (numbers.any { it !in LOTTO_NUMBER_RANGE }) {
                throw IllegalArgumentException("범위를 벗어난 숫자가 있습니다.")
            }
            if (numbers.size != numbers.toSet().size) {
                throw IllegalArgumentException("중복된 숫자가 있습니다.")
            }

            return LottoNumber(numbers)
        }
    }
}
