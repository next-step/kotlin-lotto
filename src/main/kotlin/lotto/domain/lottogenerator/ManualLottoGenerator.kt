package lotto.domain.lottogenerator

import lotto.domain.Lotto
import lotto.domain.LottoNumber

class ManualLottoGenerator(private val elements: List<Int>) : LottoGenerator {

    override fun generate(): Lotto {
        return Lotto(
            elements
                .map { LottoNumber.of(it) }
                .toSet()
        )
    }
}
