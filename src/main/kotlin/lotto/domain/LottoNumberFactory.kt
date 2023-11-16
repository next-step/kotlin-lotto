package lotto.domain

object LottoNumberFactory {
    private val lottoNumberMap = HashMap<Int, LottoNumber>().apply {
        for (num in 1..45) put(num, LottoNumber(num))
    }

    fun get(num: Int) = lottoNumberMap[num]!!
    fun all(): List<LottoNumber> = lottoNumberMap.values.toList()
}
