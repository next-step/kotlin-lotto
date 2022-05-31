package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PaymentTest {
    @ParameterizedTest
    @ValueSource(ints = [1000, 10000, 1000000])
    fun `현금으로 Payment를 초기화한다`(cash: Int) {
        Assertions.assertThat(Payment(cash)).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [999, 0, -1, -10000, -1000000])
    fun `1000원 미만이 입력되면 예외가 발생한다`(cash: Int) {
        Assertions.assertThatThrownBy { Payment(cash) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `구입 가능 로또 수를 반화한다`() {
        Assertions.assertThat(Payment(1000).getAvailableNumberOfLotto()).isEqualTo(1)
        Assertions.assertThat(Payment(9999).getAvailableNumberOfLotto()).isEqualTo(9)
    }
}
