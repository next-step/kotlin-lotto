package lotto

import lotto.LottoNumber.Companion.LOTTO_NUMBER_POOL

class LottoNumbers(numbers: List<LottoNumber>) {
    val numbers: Set<LottoNumber>

    init {
        require(numbers.size == SIZE) { LOTTO_NUMBERS_INVALID_SIZE_MESSAGE }

        this.numbers = numbers.toSortedSet(compareBy(LottoNumber::number))

        require(this.numbers.size == numbers.size) { LOTTO_NUMBERS_DUPLICATE_MESSAGE }
    }

    companion object {
        const val SIZE = 6
        const val LOTTO_NUMBERS_INVALID_SIZE_MESSAGE = "로또 번호는 6개의 숫자로 이루어져야 합니다."
        const val LOTTO_NUMBERS_DUPLICATE_MESSAGE = "로또 번호는 중복된 숫자가 존재할 수 없습니다."

        fun from(text: String): LottoNumbers {
            val numbers = text
                .split(",")
                .map { it.trim() }
                .map { it.toInt() }

            return from(numbers)
        }

        fun from(numbers: List<Int>): LottoNumbers {
            return LottoNumbers(numbers.map { LottoNumber.from(it) })
        }

        fun generateRandom(): LottoNumbers {
            val randomNumbers = LOTTO_NUMBER_POOL.shuffled().take(SIZE)

            return LottoNumbers(randomNumbers)
        }
    }
}
