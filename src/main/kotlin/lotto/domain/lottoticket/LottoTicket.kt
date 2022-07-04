package lotto.domain.lottoticket

import lotto.domain.Money
import java.math.BigDecimal

class LottoTicket private constructor(
    val lottoNumbers: LottoNumbers,
    val isAuto: Boolean
) {
    val isManual: Boolean = !isAuto

    companion object {
        val PRICE: Money = Money(BigDecimal.valueOf(1_000))

        fun manual(lottoNumbers: LottoNumbers): LottoTicket {
            return LottoTicket(
                lottoNumbers = lottoNumbers,
                isAuto = false
            )
        }

        fun auto(lottoNumbers: LottoNumbers): LottoTicket {
            return LottoTicket(
                lottoNumbers = lottoNumbers,
                isAuto = true
            )
        }
    }
}
