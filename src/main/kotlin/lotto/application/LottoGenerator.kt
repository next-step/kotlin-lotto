package lotto.application

import lotto.domain.Lotto
import lotto.domain.Lotto.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.view.InputView

object LottoGenerator {
    fun generateLottos(lottoCount: Int, manualLottos: Lottos? = null): Lottos {
        return try {
            val autoLottos = generateByLottoCount(lottoCount)
            return manualLottos?.plus(autoLottos) ?: autoLottos
        } catch (e: Exception) {
            InputView.printError(e.message!!)
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
