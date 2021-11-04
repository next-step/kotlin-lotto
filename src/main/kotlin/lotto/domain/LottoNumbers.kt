package lotto.domain

data class LottoNumbers(
    private val numbers: List<Int>,
) {
    init {
        require(numbers.size == NUMBER_SIZE) { "6개의 번호를 입력해야합니다." }
    }

    fun getMatchCount(winningNumbers: WinningNumbers): Int {
        return numbers
            .map { number ->
                winningNumbers.contains(number)
            }
            .filter { it }
            .size
    }

    fun isMatchedBonusNumber(bonusNumber: BonusNumber): Boolean {
        return numbers.contains(bonusNumber.number)
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {
        private const val NUMBER_SIZE = 6
    }
}
