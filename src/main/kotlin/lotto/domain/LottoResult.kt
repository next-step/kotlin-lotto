package lotto.domain

class LottoResult private constructor(private val result: Map<Prize, Int>) : Map<Prize, Int> by result {
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

    companion object {
        fun makeLottoResult(
            winningLotto: Lotto,
            bonusLottoNumber: LottoNumber,
            lottos: Lottos,
        ): LottoResult {
            val result = lottos.lottos.groupingBy { lotto ->
                val matchCount = lotto.countMatch(winningLotto)
                Prize.of(matchCount = matchCount, bonusLottoNumber = bonusLottoNumber, lotto = lotto)
            }.eachCount()
            return LottoResult(result)
        }
    }
}
