package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CashTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 100, 100000, 30, 4000000])
    fun `Cash는 돈을 나타내며, Int를 보관한다`(input: Int) {
        assertThat(Cash.from(input).value).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 100, -100000, -30, 4000000])
    fun `0보다 작은 값을 전달받을 경우, 0으로 저장한다`(input: Int) {
        assertThat(Cash.from(input).value).isGreaterThanOrEqualTo(0)
    }
}
