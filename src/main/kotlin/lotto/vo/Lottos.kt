package lotto.vo

import kotlin.math.floor

class Lottos(private val price: Long, val lottos: List<Lotto>) {
    fun getProfitRate(winningPrice: Long): Double {
        val profitRate = (winningPrice / this.price).toDouble()
        return floor(profitRate * 10) / 100.0
    }
}
