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
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.valueOf(it) })
        val other = Lotto.from(listOf(4, 5, 6, 7, 8, 9).map { LottoNumber.valueOf(it) })

        // when, then
        assertEquals(lotto.findMatchedNumberCount(other), 3)
    }

    @Test
    fun `중복되는 로또 번호가 있으면 예외 발생`() {
        // given, when, then
        val exception = assertThrows<IllegalArgumentException> {
            Lotto.from(listOf(1, 1, 2, 3, 4, 5).map { LottoNumber.valueOf(it) })
        }
        assertEquals("로또에 중복되는 번호가 있을 수 없습니다.", exception.message)
    }

    @Test
    fun `로또 번호 개수가 6개가 아니면 예외 발생`() {
        // given, when, then
        val exception = assertThrows<IllegalArgumentException> {
            Lotto.from(listOf(1, 2, 3, 4, 5).map { LottoNumber.valueOf(it) })
        }
        assertEquals("로또 번호 개수는 6개 이어야 합니다.", exception.message)
    }
}
