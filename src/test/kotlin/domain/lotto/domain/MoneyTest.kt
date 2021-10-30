package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("돈(Money)")
class MoneyTest {

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = [0, 1_000, 10_000, 99_999, 100_0001, Integer.MAX_VALUE])
    fun `0 이상의 정수는 Money 를 생성할 수 있다`(moneyInt: Int) {
        val money = Money(moneyInt)

        assertAll(
            { assertThat(money).isNotNull },
            { assertThat(money).isExactlyInstanceOf(Money::class.java) }
        )
    }
}