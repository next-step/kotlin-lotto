package lotto.domain.generator

import lotto.domain.generator.LottoGenerator.Companion.COUNT
import lotto.domain.generator.LottoGenerator.Companion.MAX
import lotto.domain.generator.LottoGenerator.Companion.MIN

object AutoLottoGenerator : LottoGenerator {

    override fun execute() = (MIN..MAX).shuffled().take(COUNT)
}
