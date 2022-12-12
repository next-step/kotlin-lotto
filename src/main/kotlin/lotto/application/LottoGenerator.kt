package lotto.application

import lotto.domain.Lotto
import lotto.domain.Lotto.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH
import lotto.domain.LottoNumber
import lotto.domain.LottoNumber.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MINIMUM_LOTTO_NUMBER
import lotto.domain.Lottos

object LottoGenerator {
    private val lotto = List(MAXIMUM_LOTTO_NUMBER) { LottoNumber.from(it + MINIMUM_LOTTO_NUMBER) }

    fun generateLottos(lottoCount: Int): Lottos {
        val lottoList = mutableListOf<Lotto>()
        repeat(lottoCount) {
            val lotto = generate()
            lottoList.add(lotto)
        }
        return Lottos(lottoList)
    }

    private fun generate(): Lotto {
        return Lotto(lotto.shuffled().take(MAXIMUM_LOTTO_NUMBER_LENGTH).sortedBy { it.value })
    }
}
