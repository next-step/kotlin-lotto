package lotto.domain.generator

import lotto.domain.LottoTicket

interface LottoGenerator {

    fun execute(): LottoTicket
}
