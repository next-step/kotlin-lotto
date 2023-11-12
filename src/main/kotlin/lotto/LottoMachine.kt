package lotto

import kotlin.math.floor

class LottoMachine(private val amount: Int) {

    fun getCountOfLotto(): Int {
        require(this.amount >= 0 && this.amount >= LOTTO_PRICE) { "$LOTTO_PRICE 원 이상으로 금액을 입력해주세요." }
        return (this.amount / LOTTO_PRICE)
    }

    fun getLottoList(): List<Lotto> {
        return (1..getCountOfLotto()).map { Lotto() }
    }

    companion object {
        private const val LOTTO_PRICE = 1_000

        fun checkWinningNumbers(lottos: List<Lotto>, winningNumbers: List<Int>): Map<Int, Int> {
            val winningCountMap = mutableMapOf<Int, Int>()
            for (lotto in lottos) {
                val matchingNumbers = lotto.generateCachedLottoNumbers().count { it in winningNumbers }
                winningCountMap[matchingNumbers] = winningCountMap.getOrDefault(matchingNumbers, 0) + 1
            }
            return winningCountMap
        }

        fun calculateTotalPrize(winningResult: Map<Int, Int>): Int {
            var totalPrize = 0
            for ((matchingNumbers, count) in winningResult) {
                totalPrize += LottoPrize.getPrize(matchingNumbers) * count
            }
            return totalPrize
        }

        fun calculateTotalEarning(totalPrize: Int, amount: Int): Double {
            val purchaseAmount = amount * LOTTO_PRICE
            val rate = (totalPrize.toDouble() * 100 / purchaseAmount.toDouble()) / 100
            return floor(rate * 100) / 100
        }
    }
}
