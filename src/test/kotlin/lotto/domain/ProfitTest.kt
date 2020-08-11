package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ProfitTest {
    private val profit = Profit(5000)
    private val payment = Payment(10000)

    @DisplayName("당첨금이 구입금액의 절반일 때, 수익률을 0.50로 반환한다")
    @Test
    fun `profit ratio`() {
        // when
        val ratio = profit.calculateProfitRatio(payment)

        // then
        assertThat(ratio).isEqualTo(BigDecimal(0.50).setScale(2))
    }
}
