package lotto.model.generator

import lotto.model.Lotto
import lotto.model.Numbers

object RandomNumberGenerater : LottoNumberGenerater {
    override fun generate() =
        Numbers(
            (Lotto.MIN_NUMBER..Lotto.MAX_NUMBER).shuffled().take(
                Lotto.NUMBER_COUNT
            )
        )
}
