package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumberTest {

    @Test
    fun `0 보다 작은 숫자가 포함된 경우 에러 발생 확인`() {
        assertThrows<IllegalArgumentException> { LottoNumber(-1) }
    }

    @Test
    fun `0의 숫자가 포함된 경우 에러 발생 확인`() {
        assertThrows<IllegalArgumentException> { LottoNumber(0) }
    }
}
