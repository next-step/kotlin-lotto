package lotto.domain.selling

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.WinningLottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoTicketExchangerTest {
    private val fourthLotto = LottoTicket(
        setOf(
            LottoNumber(1), LottoNumber(2), LottoNumber(3),
            LottoNumber(4), LottoNumber(5), LottoNumber(10)
        )
    )
    private val secondLotto = LottoTicket(
        setOf(
            LottoNumber(1), LottoNumber(2), LottoNumber(3),
            LottoNumber(10), LottoNumber(11), LottoNumber(13)
        )
    )
    private val winningLotto = WinningLottoTicket(
        LottoTicket(
            setOf(
                LottoNumber(1), LottoNumber(2), LottoNumber(3),
                LottoNumber(10), LottoNumber(11), LottoNumber(12)
            )
        ),
        LottoNumber(13)
    )

    @DisplayName("당첨된 로또를 상금으로 교환한다")
    @Test
    fun exchangeFourthLotto() {
        val paymentResult = PaymentResult(2300, listOf(fourthLotto, secondLotto), 300)
        assertThat(LottoExchanger.exchange(paymentResult, winningLotto)).isEqualTo(
            ExchangeResult(paymentResult, hashMapOf(Rank.SECOND to 1, Rank.FOURTH to 1))
        )
    }
}
