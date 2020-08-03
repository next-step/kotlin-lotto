package lotto.generator

import lotto.Lotto
import lotto.Numbers

object RandomNumberGenerater : LottoNumberGenerater {
    override fun generate() =
        Numbers((Lotto.MIN_NUMBER..Lotto.MAX_NUMBER).shuffled().take(Lotto.NUMBER_COUNT))
}
