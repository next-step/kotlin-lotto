package lotto.entity

class WinningNumber private constructor(
    private val numbers: Set<LottoNumber>,
    private val bonusBall: LottoNumber,
) {
    init {
        require(numbers.size == NUMBER_OF_WINNING_NUMBER) { "당첨번호는 중복없는 6개의 숫자여야합니다." }
        require(numbers.contains(bonusBall).not()) { "보너스 볼에는 당첨 번호가 포함되면 안됩니다." }
    }

    fun calculateLottoResults(lottos: List<Lotto>): Map<Rank, Int> {
        val lottoResults = mutableMapOf<Rank, Int>()
        lottos.forEach {
            val rank = Rank.whatRank(it, numbers, bonusBall)
            lottoResults[rank] = lottoResults.getOrDefault(rank, 0) + 1
        }
        return lottoResults
    }

    companion object {
        private const val NUMBER_OF_WINNING_NUMBER = 6

        fun of(numbers: List<Int>, bounusBall: Int): WinningNumber {
            return WinningNumber(numbers = numbers.map { LottoNumber(it) }.toSet(), LottoNumber(bounusBall))
        }
    }
}
