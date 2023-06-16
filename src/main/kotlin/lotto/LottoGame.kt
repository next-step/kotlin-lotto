package lotto

class LottoGame(val lottoNumbers: List<LottoNumbers>, private val winningNumbers: WinningNumbers) {
    val result: Map<Rank, Int> = lottoNumbers.map { winningNumbers.calculateRank(it) }
        .groupBy { it }
        .mapValues { it.value.size }

    companion object {
        const val GAME_COST = 1000

        fun getGameCount(purchaseAmount: Int): Int {
            return purchaseAmount / GAME_COST
        }

        fun from(count: Int, winningNumbers: WinningNumbers): LottoGame {
            val lottoNumbers = List(count) { LottoNumbers.generateRandom() }

            return LottoGame(lottoNumbers, winningNumbers)
        }
    }
}
