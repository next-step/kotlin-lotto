package lotto.domain.generator

import lotto.domain.lotto.LottoTicket

interface LottoGenerator {

    fun execute(): LottoTicket
}
