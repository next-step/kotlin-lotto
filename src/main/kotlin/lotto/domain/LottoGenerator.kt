package lotto.domain

import lotto.domain.Lotto.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH

object LottoGenerator {
    fun generateLottos(lottoCount: Int, manualLottos: Lottos? = null): Lottos {
        return try {
            val autoLottos = generateByLottoCount(lottoCount)
            return manualLottos?.plus(autoLottos) ?: autoLottos
        } catch (e: Exception) {
            generateLottos(lottoCount, manualLottos)
        }
    }

    private fun generateByLottoCount(lottoCount: Int): Lottos {
        return Lottos(List(lottoCount) { generate() })
    }

    private fun generate(): Lotto {
        return Lotto(
            LottoNumber.lotto
                .shuffled()
                .take(MAXIMUM_LOTTO_NUMBER_LENGTH)
                .sortedBy { it.value }
        )
    }
}
