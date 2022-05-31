package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

@DisplayName("로또 테스트")
class LottoTest {

    @Test
    fun `동일한 로또 번호 개수 찾는 기능이 정상 동작`() {
        // given
        val lotto = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
        val other = Lotto.of(listOf(4, 5, 6, 7, 8, 9))

        // when, then
        assertEquals(lotto.findMatchedNumberCount(other), 3)
    }

    @Test
    fun `중복되는 로또 번호가 있으면 예외 발생`() {
        // given, when, then
        val exception = assertThrows<IllegalArgumentException> { Lotto.of(listOf(1, 1, 2, 3, 4, 5)) }
        assertEquals("로또에 중복되는 번호가 있을 수 없습니다.", exception.message)
    }
}
