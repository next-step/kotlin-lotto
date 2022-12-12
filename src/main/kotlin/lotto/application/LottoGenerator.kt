package lotto.application

import lotto.domain.Lotto
import lotto.domain.Lotto.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH
import lotto.domain.LottoNumber
import lotto.domain.Lottos

object LottoGenerator {
    fun generateLottos(lottoCount: Int): Lottos {
        val lottoList = mutableListOf<Lotto>()
        repeat(lottoCount) {
            val lotto = generate()
            lottoList.add(lotto)
        }
        return Lottos(lottoList)
    }

    private fun generate(): Lotto {
        return Lotto(LottoNumber.lotto.shuffled().take(MAXIMUM_LOTTO_NUMBER_LENGTH).sortedBy { it.value })
    }
}
