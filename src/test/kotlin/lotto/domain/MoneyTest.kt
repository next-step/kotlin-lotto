package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MoneyTest {

    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(ints = [0, -1])
    fun `money는 0보다 작을 수 없다`(value: Int) {
        assertThrows<IllegalArgumentException> { Money(value) }
    }

    @Test
    fun `정상 생성 테스트`() {
        assertDoesNotThrow { Money(1) }
    }
}