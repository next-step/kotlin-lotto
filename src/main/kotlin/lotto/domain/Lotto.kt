package lotto.domain

class Lotto(
    private val numbers: List<Int>,
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
            6 -> Rank.FIRST
            5 -> Rank.SECOND
            4 -> Rank.THIRD
            3 -> Rank.FOURTH
            else -> Rank.BLANK
        }

        return rank
    }

    override fun toString(): String {
        return "$numbers"
    }

    companion object {
        private const val NUMBER_SIZE = 6
    }
}
