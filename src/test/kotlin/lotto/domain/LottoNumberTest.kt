package lotto.domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `로또 숫자는 1부터 45까지의 숫자다`() {
        assertDoesNotThrow { LottoNumber(1) }
    }

    @Test
    fun `로또 숫자가 46 이상이면 IllegalArgumentException 이 발생한다`() {
        assertThrows<IllegalArgumentException> { LottoNumber(46) }
    }
}