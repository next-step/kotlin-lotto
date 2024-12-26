package lotto

class LottoResult private constructor(private val result: Map<Prize, Int>) : Map<Prize, Int> by result {
    private val totalPrizeMoney: Int
        get() {
            return result.map {
                it.key.money * it.value
            }.sum()
        }

    override fun get(key: Prize): Int {
        return result[key] ?: 0
    }

    fun getRateOfReturn(money: Int): Float {
        return totalPrizeMoney.toFloat() / money
    }

    companion object {
        fun makeLottoResult(
            winningLotto: Lotto,
            lottos: List<Lotto>,
        ): LottoResult {
            val result = lottos.groupingBy { lotto ->
                val count = lotto.countMatch(winningLotto)
                Prize.from(count)
            }.eachCount()
            return LottoResult(result)
        }
    }
}
