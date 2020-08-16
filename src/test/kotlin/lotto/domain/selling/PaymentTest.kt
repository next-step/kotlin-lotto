package lotto.domain.selling

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PaymentTest {

    @DisplayName("수동 로또 개수는 지불한 금액보다 많은 개수를 입력받을 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = [100])
    fun isValidManualCount(count: Int) {
        assertThat(Payment.isValidManualCount(count, 1000)).isFalse()
        assertThatThrownBy { Payment(5000, count) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
