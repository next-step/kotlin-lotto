package lotto.domain

class WinningNumber(
    private val numbers: List<Int>,
    private val bonusNumber: Int,
) {
    init {
        require(numbers.size == WINNING_NUMBER_SIZE) { "당첨번호는 6개여야 합니다." }
        require(!numbers.contains(bonusNumber)) { "보너스 번호와 당첨번호는 중복될 수 없습니다." }
    }

    fun contain(number: Int): Boolean {
        return numbers.contains(number)
    }

    fun isMatchedBonusNumber(numbers: List<Int>): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        private const val WINNING_NUMBER_SIZE = 6
    }
}
