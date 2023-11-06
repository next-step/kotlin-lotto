package autolotto.vo

import kotlin.math.floor

class AutoLotto(val price: Long, private val originLottos: List<Lotto> = listOf()) {
    val count: Int = initCount(price)
    val lottos: List<Lotto> = originLottos.ifEmpty { createLottoList() }

    private fun initCount(price: Long): Int {
        require(price >= 0) { "가격은 음수가 될 수 없습니다." }
        return (price / LOTTO_PRICE_PER_ONE).toInt()
    }

    private fun createLottoList(): List<Lotto> {
        return (1..count).map { Lotto() }
    }

    fun calculateTotalWinningPrice(winningNumbers: List<Int>): Long {
        return lottos.map { it.checkWinning(winningNumbers) }.sumOf { it.second.winningPrice }
    }

    fun getProfitRate(winningPrice: Double): Double {
        val profitRate = (winningPrice / this.price)
        return floor(profitRate * 10) / 100.0
    }

    companion object {
        private const val LOTTO_PRICE_PER_ONE = 1000L
    }
}
