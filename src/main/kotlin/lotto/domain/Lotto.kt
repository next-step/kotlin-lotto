package lotto.domain

class Lotto(
    val numbers: List<Int>,
    val price: Int,
) {
    init {
        require(numbers.size == NUMBER_SIZE) { "6개의 번호를 입력해야합니다." }
    }

    fun sortilege(
        winningNumber: WinningNumber,
    ): Rank {
        val matchCount = numbers
            .map { number ->
                winningNumber.contain(number)
            }
            .filter { it }

        val isMatchedBonusNumber = winningNumber.isMatchedBonusNumber(numbers)

        return Rank.findBy(matchCount.size, isMatchedBonusNumber)
    }

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val NUMBER_SIZE = 6
    }
}
