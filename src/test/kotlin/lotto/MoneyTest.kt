package lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = [999, 0, -1])
    fun `금액이 1000원 미만이면 RuntimeException 발생`(money: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            Money(money)
        }
    }
}