package specific.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = [-10, -1])
    fun `돈은 양의 정수이다`(principal: Long) {
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
