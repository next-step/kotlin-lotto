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

        val rank = when (matchCount.size) {
            SIX_MATCH -> Rank.FIRST
            FIVE_MATCH -> Rank.SECOND
            FOUR_MATCH -> Rank.THIRD
            THREE_MATCH -> Rank.FOURTH
            else -> Rank.BLANK
        }

        return rank
    }

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val NUMBER_SIZE = 6
        private const val SIX_MATCH = 6
        private const val FIVE_MATCH = 5
        private const val FOUR_MATCH = 4
        private const val THREE_MATCH = 3
    }
}
