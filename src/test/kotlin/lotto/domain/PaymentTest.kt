package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PaymentTest {

    @Test
    fun `validate amount`() {
        assertThat(Payment(1).money).isEqualTo(0)
        assertThat(Payment(1000).money).isEqualTo(1000)
    }
}
