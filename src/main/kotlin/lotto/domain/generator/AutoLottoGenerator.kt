package lotto.domain.generator

import lotto.domain.lotto.LottoNumber
import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType

object AutoLottoGenerator {

    fun execute() = LottoTicket(
        LottoType.AUTO,
        LottoNumber.NUMBER_RANGE.shuffled()
            .take(LottoTicket.NUMBER_COUNT)
            .mapNotNull { LottoNumber(it) }
            .toSortedSet()
    )
}
