package lotto.domain.selling

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ExchangeResultTest {

    @DisplayName("수익률을 계산한다")
    @Test
    fun calculateRateOfReturn() {
        val lottoTicket = LottoTicket(
            setOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3),
                LottoNumber(4), LottoNumber(5), LottoNumber(6)
            )
        )
        val exchangeResult = ExchangeResult(
            PaymentResult(1230, listOf(lottoTicket), 0),
            hashMapOf(Prize.FOURTH to 1)
        )
        assertThat(exchangeResult.rateOfReturn.toDouble()).isEqualTo(4.06)
    }
}
