package lotto.domain

class LottoResult(private val result: Map<Prize, Int>) : Map<Prize, Int> by result {
    private val totalPrizeMoney: Long
        get() {
            return result.map {
                it.key.money.toLong() * it.value
            }.sum()
        }

    override fun get(key: Prize): Int {
        return result[key] ?: 0
    }

    fun getRateOfReturn(money: Int): Float {
        return totalPrizeMoney.toFloat() / money
    }
}
