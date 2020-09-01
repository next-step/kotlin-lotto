package lotto.domain.selling

import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoType
import lotto.domain.lotto.WinningLottoTicket
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class PaymentResultTest {
    private lateinit var winningLotto: WinningLottoTicket
    private lateinit var paymentResult: PaymentResult

    @BeforeEach
    fun setUp() {
        winningLotto = WinningLottoTicket.of(LottoTicket.of(LottoType.MANUAL, 1, 2, 3, 10, 11, 12)!!, 13)!!
        paymentResult = PaymentResult(
            2300,
            300,
            listOf(
                LottoTicket.of(LottoType.AUTO, 1, 2, 3, 4, 5, 10)!!,
                LottoTicket.of(LottoType.MANUAL, 1, 2, 3, 10, 11, 13)!!
            )
        )
    }

    @DisplayName("당첨된 로또를 상금으로 교환한다")
    @Test
    fun exchangeFourthLotto() {
        assertThat(paymentResult.exchange(winningLotto)).isEqualTo(
            ExchangeResult(2300, hashMapOf(Rank.SECOND to 1, Rank.FOURTH to 1))
        )
    }

    @DisplayName("타입에 맞는 로또를 찾는다")
    @ParameterizedTest
    @EnumSource(LottoType::class)
    fun findLottoTickets(lottoType: LottoType) {
        assertThat(paymentResult.findLottoTickets(lottoType)).allMatch { it.lottoType == lottoType }
    }
}
