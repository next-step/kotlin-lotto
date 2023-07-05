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
        const val GAME_COST = 1000
        const val INVALID_MANUAL_GAME_COUNT_MESSAGE = "수동으로 구매할 로또의 금액은 전체 구입 금액 초과할 수 없습니다. purchaseAmount:%d, manualGameCost:%d"

        fun getAutoGameCount(purchaseAmount: Int, manualGameCount: Int): Int {
            val manualGameCost = manualGameCount * GAME_COST
            require(purchaseAmount >= manualGameCost) { INVALID_MANUAL_GAME_COUNT_MESSAGE.format(purchaseAmount, manualGameCost) }

            return (purchaseAmount - manualGameCost) / GAME_COST
        }
    }
}
