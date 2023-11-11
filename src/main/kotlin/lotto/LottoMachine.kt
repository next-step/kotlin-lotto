package lotto

import kotlin.math.floor

class LottoMachine(private val amount: Int, private val originLottos: List<Lotto> = listOf()) { 
    val count: Int = getCountOfLotto(amount)
    val lottos: List<Lotto> = originLottos.ifEmpty { getLottoList() }

   // 구매한 갯수를 확인한다.
   fun getCountOfLotto(price: Int): Int {
        require(price >= 0 && price >= LOTTO_PRICE) { LOTTO_PRICE.toString() + "원 이상으로 금액을 입력해주세요." }
        return (price / LOTTO_PRICE)
    }


   // 구매한 수 만큼 로또를 발급해준다.
     fun getLottoList(): List<Lotto> {
         return (1..count).map { Lotto() }
    }


    // 당첨 숫자를 확인한다.
    fun checkWinningNumbers(winningNumbers: List<Int>): Map<Int, Int> {
        val winningCountMap = mutableMapOf<Int, Int>()
        for (lotto in lottos) {
            val matchingNumbers = lotto.numbers.count { it in winningNumbers }
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

    fun calculateTotalEarning(totalPrize: Int): Double {
        val rate =  (totalPrize.toDouble() * 100 / this.amount.toDouble()) / 100
        return floor(rate * 100) / 100
    }

    companion object {
        private const val LOTTO_PRICE = 1_000
    }
}
