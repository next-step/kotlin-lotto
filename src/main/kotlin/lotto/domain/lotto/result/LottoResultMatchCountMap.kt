package lotto.domain.lotto.result

data class LottoResultMatchCountMap(
    val resultMatchCountMap: Map<Int, Int>
) : Map<Int, Int> by resultMatchCountMap {

    override fun get(key: Int): Int = resultMatchCountMap.getOrDefault(key, 0)
}
