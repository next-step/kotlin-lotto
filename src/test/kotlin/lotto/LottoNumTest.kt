package lotto

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

internal class LottoNumTest {

    @Test
    fun `번호는 1부터 45이다`() {
        assertDoesNotThrow { LottoNum(1) }
        assertDoesNotThrow { LottoNum(45) }
        assertThrows<IllegalArgumentException> { LottoNum(0) }
        assertThrows<IllegalArgumentException> { LottoNum(46) }
    }
}
