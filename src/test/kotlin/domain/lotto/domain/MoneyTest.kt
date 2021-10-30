package domain.lotto.domain

import domain.lotto.error.InvalidMoneyRangeException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
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

    @ParameterizedTest(name = "입력값 : {0}")
    @ValueSource(ints = [-1, -1_000, -10_000, -99_999, -100_0001, Integer.MIN_VALUE])
    fun `0 미만인 음수는 Money 를 생성할 수 없다`(moneyInt: Int) {
        val exception = assertThrows<InvalidMoneyRangeException> { Money(moneyInt) }

        assertThat(exception.message).isEqualTo("%s는 Money 의 범위를 벗어난 값입니다.".format(moneyInt))
    }
}