package lotto.application

import lotto.domain.Lotto
import lotto.domain.Lotto.Companion.MAXIMUM_LOTTO_NUMBER_LENGTH
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.view.InputView

object LottoGenerator {
    fun generateLottos(lottoCount: Int, manualLottos: Lottos? = null): Lottos {
        return try {
            generateLottosWithManualLottos(manualLottos, lottoCount)
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            generateLottos(lottoCount, manualLottos)
        }
    }

    private fun generateLottosWithManualLottos(manualLottos: Lottos?, lottoCount: Int): Lottos {
        val lottoList = mutableListOf<Lotto>()
        if (manualLottos != null) {
            lottoList.addAll(manualLottos.value)
        }
        repeat(lottoCount) {
            val lotto = generate()
            lottoList.add(lotto)
        }
        return Lottos(lottoList.toList())
    }

    private fun generate(): Lotto {
        return Lotto(LottoNumber.lotto.shuffled().take(MAXIMUM_LOTTO_NUMBER_LENGTH).sortedBy { it.value })
    }
}
