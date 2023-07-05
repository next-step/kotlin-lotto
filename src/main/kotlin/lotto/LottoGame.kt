package lotto

class LottoGame(private val winningNumbers: WinningNumbers) {
    fun calculate(lottoNumbers: List<LottoNumbers>): LottoResult {
        return LottoResult(
            winningNumbers.calculateRank(lottoNumbers)
                .groupBy { it }
                .mapValues { it.value.size }
        )
    }

    fun calculate(lottoNumbers: LottoNumbers): LottoResult {
        return calculate(listOf(lottoNumbers))
    }

    companion object {
        private const val GAME_COST = 1000

        fun getGameCount(purchaseAmount: Int): Int {
            return purchaseAmount / GAME_COST
        }
    }
}
