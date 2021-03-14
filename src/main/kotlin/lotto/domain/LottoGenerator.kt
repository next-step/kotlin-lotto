package lotto.domain

import lotto.vo.Lotto
import lotto.vo.LottoNumber

object LottoGenerator {
    fun generate(): Lotto {
        val autoLotto = mutableSetOf<Int>()
        (1..Lotto.LOTTO_SIZE).forEach { _ ->
            autoLotto.add(makeAutoNumber(autoLotto))
        }
        return Lotto.of(autoLotto)
    }

    private fun makeAutoNumber(exceptList: Set<Int>): Int {
        val result = LottoNumber.LOTTO_NUM_RANGE.random()
        return if (result !in exceptList) result else makeAutoNumber(exceptList)
    }
}
