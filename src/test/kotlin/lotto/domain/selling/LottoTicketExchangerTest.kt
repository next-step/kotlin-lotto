package lotto.domain.selling

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTicketExchangerTest {
    private val myLotto = LottoTicket(
        setOf(
            LottoNumber(1), LottoNumber(2), LottoNumber(3),
            LottoNumber(4), LottoNumber(5), LottoNumber(6)
        )
    )
    private val winningLotto = LottoTicket(
        setOf(
            LottoNumber(1), LottoNumber(2), LottoNumber(3),
            LottoNumber(10), LottoNumber(11), LottoNumber(12)
        )
    )

    @DisplayName("번호가 3개 이상 일치한 로또를 상금으로 교환한다")
    @Test
    fun exchange() {
        val paymentResult = PaymentResult(1300, listOf(myLotto), 300)
        assertThat(LottoPrizeExchanger.exchange(paymentResult, winningLotto)).isEqualTo(
            ExchangeResult(paymentResult, hashMapOf(Prize.FOURTH to 1))
        )
    }
}
