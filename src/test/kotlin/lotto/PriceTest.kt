package lotto

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PriceTest {
    @ParameterizedTest
    @ValueSource(ints = [0, -100])
    fun `금액이 0원 이하이면 RuntimeException 발생`(money: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            Price(money)
        }
    }
}
