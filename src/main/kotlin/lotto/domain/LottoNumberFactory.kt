package lotto.domain

import java.lang.IllegalArgumentException

object LottoNumberFactory {
    private val lottoNumberMap = HashMap<Int, LottoNumber>().apply {
        for (num in 1..45) put(num, LottoNumber(num))
    }

    fun get(num: Int) = lottoNumberMap[num] ?: throw IllegalArgumentException()
    fun all(): List<LottoNumber> = lottoNumberMap.values.toList()
}
