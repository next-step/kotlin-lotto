package lotto.entity

class WinningNumber private constructor(
    private val numbers: Set<LottoNumber>,
) {
    init {
        require(numbers.size == 6) { "당첨번호는 중복없는 6개의 숫자여야합니다." }
    }

    fun howManyNumberMatches(lotto: Lotto): Rank =
        when (numbers.count { lotto.numbers.contains(it) }) {
            3 -> Rank.Fourth
            4 -> Rank.Third
            5 -> Rank.Second
            6 -> Rank.First
            else -> Rank.None
        }

    companion object {
        fun of(numbers: List<String>): WinningNumber {
            return WinningNumber(numbers = numbers.map { LottoNumber(it.toInt()) }.toSet())
        }
    }
}

sealed class Rank(val prize: Long) {
    object First : Rank(FIRST_PRIZE)
    object Second : Rank(SECOND_PRIZE)
    object Third : Rank(THIRD_PRIZE)
    object Fourth : Rank(FOURTH_PRIZE)
    object None : Rank(NO_PRIZE)

    companion object {
        private const val FIRST_PRIZE = 2000000000L
        private const val SECOND_PRIZE = 1500000L
        private const val THIRD_PRIZE = 50000L
        private const val FOURTH_PRIZE = 5000L
        private const val NO_PRIZE = 0L
    }
}
