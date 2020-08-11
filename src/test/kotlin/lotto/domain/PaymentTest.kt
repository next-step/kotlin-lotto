package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PaymentTest {

    @DisplayName("1000원 이상의 가격인지 확인한다 (충분치 않으면 0원 처리)")
    @Test
    fun `validate amount`() {
        assertThat(Payment(900).money).isEqualTo(0)
        assertThat(Payment(1000).money).isEqualTo(1000)
    }

    @DisplayName("들어온 금액에서 구입 가능한 로또 개수를 반환한다")
    @Test
    fun `sold quantity`() {
        assertThat(Payment(900).availableQuantity()).isEqualTo(0)
        assertThat(Payment(1000).availableQuantity()).isEqualTo(1)
    }
}
