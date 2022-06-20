package lotto.domain

import java.math.BigDecimal

class LottoTicket constructor(
    val lottoNumbers: LottoNumbers,
) {
    companion object {
        val PRICE: Money = Money(BigDecimal.valueOf(1_000))
    }
}
