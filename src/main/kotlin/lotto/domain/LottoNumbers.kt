package lotto.domain

import lotto.argumentError

class LottoNumbers(
    private val numbers: List<LottoNumber>
) {
    init {
        check(numbers.size == LOTTO_NUMBER_SET) {
            argumentError("로또는 중복 없는 6자리 번호여야합니다.")
        }
    }

    fun matches(inputNumbers: LottoNumbers): Int {
        return numbers.filter { number ->
            inputNumbers.numbers.contains(number)
        }.size
    }

    override fun toString(): String {
        return numbers.joinToString(", ") { number -> number.toString() }
    }

    companion object {
        private const val LOTTO_NUMBER_SET = 6
        private val LOTTO_NUMBERS = (1..45)

        fun from(): LottoNumbers {
            val selected = LOTTO_NUMBERS.shuffled()
                .take(6)
                .sorted()
                .map { number ->
                    LottoNumber(number)
                }

            return LottoNumbers(
                selected
            )
        }

        fun from(input: String): LottoNumbers {
            val numbers = input.split(",")
                .map { split ->
                    split.trim().toInt()
                }.sorted()
                .map(::LottoNumber)

            return LottoNumbers(
                numbers
            )
        }
    }
}
