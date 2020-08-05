package lotto.domain.selling

import lotto.domain.Lotto
import lotto.domain.generator.ManualLottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoExchangerTest {
    private val myLotto = Lotto(ManualLottoGenerator("1, 2, 3, 10, 11, 12"))
    private val winningLotto = Lotto(ManualLottoGenerator("1, 2, 3, 4, 5, 6"))

    @DisplayName("번호가 3개 이상 일치한 로또를 상금으로 교환한다")
    @Test
    fun exchangeLottoes() {
        val paymentResult = PaymentResult(1000, listOf(myLotto), 0)
        assertThat(LottoExchanger.exchange(paymentResult.lottoes, winningLotto)).isEqualTo(
            ExchangeResult(hashMapOf(3 to 1))
        )
    }
}
