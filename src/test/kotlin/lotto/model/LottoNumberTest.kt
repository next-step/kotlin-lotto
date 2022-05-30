package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또 숫자 테스트")
class LottoNumberTest {

    @Test
    fun `로또 숫자가 1 미만이면 예외 발생`() {
        // given, when, then
        val exception = assertThrows<IllegalArgumentException> { LottoNumber.from(0) }
        assertEquals("로또 숫자는 최소 1 이상이어야 합니다. (number: 0)", exception.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun `로또 숫자 정상 생성`(number: Int) {
        // when
        val lottoNumber = LottoNumber.from(number)

        // then
        assertEquals(lottoNumber.number, number)
    }

    @Test
    fun `로또 숫자 재사용`() {
        // given, when, then
        assertSame(LottoNumber.from(1), LottoNumber.from(1))
    }
}
