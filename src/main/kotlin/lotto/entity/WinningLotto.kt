package lotto.entity

class WinningNumber private constructor(
    private val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == NUMBER_OF_WINNING_NUMBER) { "당첨번호는 중복없는 6개의 숫자여야합니다." }
    }

    fun calculateLottoResults(lottos: List<Lotto>): Map<Rank, Int> {
        val rankToInt = mutableMapOf<Rank, Int>()
        lottos.forEach {
            val rank = whatRank(it)
            rankToInt[rank] = rankToInt.getOrDefault(rank, 1)
        }
        return rankToInt
    }

    private fun whatRank(lotto: Lotto): Rank =
        when (numbers.count { lotto.numbers.contains(it) }) {
            3 -> Rank.Fourth
            4 -> Rank.Third
            5 -> Rank.Second
            6 -> Rank.First
            else -> Rank.None
        }

    companion object {
        private const val NUMBER_OF_WINNING_NUMBER = 6

        fun of(numbers: List<Int>): WinningNumber {
            return WinningNumber(numbers = numbers.map { LottoNumber(it) }.toSet())
        }
    }
}

enum class Rank(val prize: Long) {
    First(prize = 2000000000L),
    Second(prize = 1500000L),
    Third(prize = 50000L),
    Fourth(prize = 5000L),
    None(prize = 0L)
}
