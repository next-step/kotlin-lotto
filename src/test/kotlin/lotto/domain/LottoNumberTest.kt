package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoNumberTest {

    @Test
    fun `0 보다 작은 숫자가 포함된 경우 에러 발생 확인`() {
        assertThrows<IllegalArgumentException> { listOf(1, 2, 3, 4, 5, -1).map { LottoNumber(it) } }
    }

    @Test
    fun `0의 숫자가 포함된 경우 에러 발생 확인`() {
        assertThrows<IllegalArgumentException> { listOf(1, 2, 3, 4, 5, 0).map { LottoNumber(it) } }
    }
}
