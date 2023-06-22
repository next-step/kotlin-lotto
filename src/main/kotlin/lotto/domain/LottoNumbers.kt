package lotto.domain

data class LottoNumbers(
    val numbers: Set<Int>,
) {
    init {
        require(numbers.size == LENGTH) { "로또 번호는 $LENGTH 개의 숫자로 이루어져 있어야 합니다." }
        require(numbers.all(::inValidRange)) { "로또 번호는 $MINIMUM~$MAXIMUM 사이의 수여야 합니다." }
    }

    fun numberOfOverlaps(other: LottoNumbers): Int {
        return numbers.count {
            it in other.numbers
        }
    }

    private fun inValidRange(number: Int): Boolean = number in MINIMUM..MAXIMUM

    companion object {
        const val LENGTH = 6
        const val MINIMUM = 1
        const val MAXIMUM = 45

        fun inValidRange(number: Int): Boolean = number in MINIMUM..MAXIMUM

        fun generate(): LottoNumbers {
            val randomNumbers = DuplicateFreeSequenceGenerator.generate(MINIMUM, MAXIMUM, LENGTH)
            return LottoNumbers(
                numbers = randomNumbers.toSet()
            )
        }
    }
}
