package lotto.domain

import lotto.domain.LottoGenerator.Companion.COUNT
import lotto.domain.LottoGenerator.Companion.MAX
import lotto.domain.LottoGenerator.Companion.MIN

object AutoLottoGenerator : LottoGenerator {

    override fun execute() = (MIN..MAX).shuffled().take(COUNT)
}
