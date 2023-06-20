package lotto

class LottoGame(val lottoNumbers: List<LottoNumbers>, winningNumbers: WinningNumbers) {
    val result: LottoResult = LottoResult(winningNumbers.calculateRank(lottoNumbers)
        .groupBy { it }
        .mapValues { it.value.size })


    companion object {
        private const val GAME_COST = 1000

        fun getGameCount(purchaseAmount: Int): Int {
            return purchaseAmount / GAME_COST
        }

        fun generateRandomNumbers(): LottoNumbers {
            val randomNumbers = LottoNumber.LOTTO_NUMBER_POOL.shuffled().take(LottoNumbers.SIZE)

            return LottoNumbers(randomNumbers)
        }

        fun from(count: Int, winningNumbers: WinningNumbers): LottoGame {
            val lottoNumbers = List(count) { generateRandomNumbers() }

            return LottoGame(lottoNumbers, winningNumbers)
        }
    }
}
