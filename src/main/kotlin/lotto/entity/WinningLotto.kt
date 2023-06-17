package lotto.entity

class WinningNumber private constructor(
    private val numbers: Set<LottoNumber>,
    private val bonusBall: LottoNumber
) {
    init {
        require(numbers.size == NUMBER_OF_WINNING_NUMBER) { "당첨번호는 중복없는 6개의 숫자여야합니다." }
        require(numbers.contains(bonusBall).not()) { "보너스 볼에는 당첨 번호가 포함되면 안됩니다." }
    }

    fun calculateLottoResults(lottos: List<Lotto>): Map<Rank, Int> {
        val rankToInt = mutableMapOf<Rank, Int>()
        lottos.forEach {
            val rank = whatRank(it)
            rankToInt[rank] = rankToInt.getOrDefault(rank, 0) + 1
        }
        return rankToInt
    }

    private fun whatRank(lotto: Lotto): Rank {
        val winningNumber = numbers + bonusBall
        return when (winningNumber.count { lotto.numbers.contains(it) }) {
            Rank.Fourth.countOfMatch -> Rank.Fourth
            Rank.Third.countOfMatch -> Rank.Third
            Rank.First.countOfMatch -> determineFirstOrSecond(lotto)
            else -> Rank.None
        }
    }

    private fun determineFirstOrSecond(lotto: Lotto): Rank =
        if (lotto.numbers.contains(bonusBall)) {
            Rank.Second
        } else {
            Rank.First
        }

    companion object {
        private const val NUMBER_OF_WINNING_NUMBER = 6

        fun of(numbers: List<Int>, bounusBall: Int): WinningNumber {
            return WinningNumber(numbers = numbers.map { LottoNumber(it) }.toSet(), LottoNumber(bounusBall))
        }
    }
}

enum class Rank(val countOfMatch: Int, val prize: Long) {
    First(countOfMatch = 6, prize = 2000000000L),
    Second(countOfMatch = 6, prize = 1500000L),
    Third(countOfMatch = 5, prize = 50000L),
    Fourth(countOfMatch = 3, prize = 5000L),
    None(countOfMatch = 0, prize = 0L),
}
