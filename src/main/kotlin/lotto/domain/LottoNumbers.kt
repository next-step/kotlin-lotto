package lotto.domain

data class LottoNumbers(
    val numbers: List<Int>,
) {
    init {
        require(numbers.size == LENGTH) { "로또 번호는 $LENGTH 개의 숫자로 이루어져 있어야 합니다." }
        require(numbers.all(::inValidRange)) { "로또 번호는 $MINIMUM~$MAXIMUM 사이의 수여야 합니다." }
        require(hasUniqueNumbers()) { "로또 번호에 중복된 수가 있으면 안됩니다." }
    }

    fun numberOfOverlaps(other: LottoNumbers): Int {
        return numbers.count {
            it in other.numbers
        }
    }

    private fun inValidRange(number: Int): Boolean = number in MINIMUM..MAXIMUM

    private fun hasUniqueNumbers(): Boolean {
        return numbers.groupingBy { it }
            .eachCount()
            .all {
                it.value == 1
            }
    }

    companion object {
        const val LENGTH = 6
        private const val MINIMUM = 1
        private const val MAXIMUM = 45

        fun generate(): LottoNumbers {
            return LottoNumbers(generateLottoNumbers())
        }

        private fun generateLottoNumbers(): List<Int> = (MINIMUM..MAXIMUM).shuffled()
            .take(LENGTH)
            .sorted()
    }
}
