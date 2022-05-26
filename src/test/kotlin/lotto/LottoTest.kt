package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoTest {

    @Test
    fun `0 보다 작은 숫자가 포함된 경우 에러 발생 확인`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5, -1)) }
    }

    @Test
    fun `0의 숫자가 포함된 경우 에러 발생 확인`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5, 0)) }
    }

    @Test
    fun `로또 6자리 확인`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(1, 2, 3, 4, 5, 6, 7)) }
    }

    @Test
    fun `1~45 까지 6자리의 숫자가 포함된 정상적인 상황 확인`() {
        val expected = listOf(1, 2, 3, 4, 5, 6)
        assertThat(Lotto(expected).numbers).isEqualTo(expected)
    }
}
