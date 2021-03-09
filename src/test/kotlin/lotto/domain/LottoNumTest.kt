package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class LottoNumTest {

    @Test
    fun `번호는 1부터 45이다`() {
        assertDoesNotThrow { LottoNum.of(1) }
        assertDoesNotThrow { LottoNum.of(45) }
        assertThrows<IllegalArgumentException> { LottoNum.of(0) }
        assertThrows<IllegalArgumentException> { LottoNum.of(46) }
    }
}
