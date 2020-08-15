package lotto.domain.selling

import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType
import lotto.domain.lotto.WinningLottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class PaymentResultTest {
    private val fourthLotto = LottoTicket(LottoType.AUTO, 1, 2, 3, 4, 5, 10)
    private val secondLotto = LottoTicket(LottoType.MANUAL, 1, 2, 3, 10, 11, 13)
    private val winningLotto = WinningLottoTicket(LottoTicket(LottoType.MANUAL, 1, 2, 3, 10, 11, 12), 13)

    @DisplayName("당첨된 로또를 상금으로 교환한다")
    @Test
    fun exchangeFourthLotto() {
        val paymentResult = PaymentResult(2300, listOf(fourthLotto, secondLotto), 300)
        assertThat(LottoExchanger.exchange(paymentResult, winningLotto)).isEqualTo(
            ExchangeResult(2300, hashMapOf(Rank.SECOND_HAS_BONUS to 1, Rank.FOURTH to 1))
        )
    }
}
