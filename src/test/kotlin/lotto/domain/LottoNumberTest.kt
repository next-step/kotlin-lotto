package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `범위를 벗어나는 번호를 받으면 에러를 일으킨다`() {
        assertThrows<IllegalArgumentException> { LottoNumber(0) }
    }
}
