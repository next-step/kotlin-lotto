package lotto.domain

import lotto.vo.LottoNumber.Companion.LOTTO_NUM_RANGE

object LottoGenerator {
    fun generate(): Lotto {
        val autoLotto = LOTTO_NUM_RANGE.shuffled().subList(0, Lotto.LOTTO_SIZE).toSet()
        return Lotto.of(autoLotto)
    }
}
