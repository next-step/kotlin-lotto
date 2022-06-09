package lotto.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 100, 100000, 30, 4000000])
    fun `Money는 돈을 나타내며, Int를 보관한다`(input: Int) {
        assertThat(Money.from(input).value).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 100, -100000, -30, 4000000])
    fun `0보다 작은 값을 전달받을 경우, 0으로 저장한다`(input: Int) {
        assertThat(Money.from(input).value).isGreaterThanOrEqualTo(0)
    }

    @Test
    fun `빼기 연산자를 사용해 빼기 연산을 수행할 수 있다`() {
        val count1 = Money.from(10)
        val count2 = Money.from(5)

        assertThat(count1 - count2).isEqualTo(Money.from(5))
    }
}
