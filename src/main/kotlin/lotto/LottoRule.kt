package lotto

class LottoRule(val correctNumber: List<LottoNumber>) {

    fun calculateResult(lottos: List<Lotto>): LottoResult {
        val lottoResultMap: MutableMap<Prize, Int> = Prize.values().associateWith { 0 }.toMutableMap()
        lottos.forEach { lotto ->
            val prize = calculatePrize(lotto)
            lottoResultMap[prize] = lottoResultMap.getValue(prize) + 1
        }
        val totalPrize = lottoResultMap.map { (prize, count) -> prize.amount.value * count }.sum()
        return LottoResult(lottoResultMap, totalPrize, lottos.size)
    }

    fun calculatePrize(lotto: Lotto): Prize {
        val sameCount = correctNumber.count { lotto.contains(it) }
        return Prize.fromSameCount(sameCount)
    }
}
