package lotto.domain.lotto.result

data class LottoResultCountMap(val resultCountMap: Map<Int, Int>) : Map<Int, Int> by resultCountMap {

    override fun get(key: Int): Int = resultCountMap.getOrDefault(key, 0)
}
