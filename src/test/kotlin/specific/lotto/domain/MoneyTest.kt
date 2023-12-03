package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = [-10, -1, 500])
    fun `입력받은 돈은 로또를 1장 이상 구매할 수 있어야 한다`(principal: Long) {
        // given, when, then
        assertThrows<IllegalArgumentException> { Money(principal) }
    }

    @Test
    fun `수익률은 현재 가진 금액을 원금으로 나눈 값이다`() {
        // given
        val money = Money(1000)
        money.make(1000)

        // when
        val returnOnInvestment = money.calculateReturnOnInvestment()

        // then
        assertEquals(2.0, returnOnInvestment)
    }
}
