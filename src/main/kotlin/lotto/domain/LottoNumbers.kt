package lotto.domain

data class LottoNumbers(
    val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == LENGTH) { "로또 번호는 $LENGTH 개의 숫자로 이루어져 있어야 합니다." }
    }

    fun numberOfOverlaps(other: LottoNumbers): Int {
        return numbers.count {
            it in other.numbers
        }
    }

    companion object {
        const val LENGTH = 6

        fun generate(): LottoNumbers {
            val randomNumbers =
                DuplicateFreeSequenceGenerator.generate(LottoNumber.MINIMUM, LottoNumber.MAXIMUM, LENGTH)
            return fromNumbers(randomNumbers)
        }

        fun fromNumbers(numberSet: Set<Int>): LottoNumbers {
            return LottoNumbers(
                numbers = numberSet.map {
                    LottoNumber.get(it)
                }.toSet()
            )
        }
    }
}
