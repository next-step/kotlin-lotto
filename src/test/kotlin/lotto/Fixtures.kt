package lotto

import lotto.model.Lotto
import lotto.model.LottoNumber

object Fixtures {
    fun createSixLottoNumber(numbers: List<Int>): List<LottoNumber> {
        return numbers.map { LottoNumber.from(it) }
            .toList()
    }

    fun createManualLottos(manualCount: Int): List<Lotto> {
        val manualLottos = mutableListOf<Lotto>()
        repeat(manualCount) {
            manualLottos.add(Lotto(Fixtures.createSixLottoNumber(listOf(1, 2, 3, 4, 5, 6))))
        }
        return manualLottos
    }
}
