package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class LottoNumTest {

    @Test
    fun `번호는 1부터 45이다`() {
        assertDoesNotThrow { LottoNum.from(1) }
        assertDoesNotThrow { LottoNum.from(45) }
        assertThrows<IllegalArgumentException> { LottoNum.from(0) }
        assertThrows<IllegalArgumentException> { LottoNum.from(46) }
    }
}
