package lotto.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또 숫자 테스트")
class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또 숫자가 1 미만 또는 45 초과이면 예외 발생`(number: Int) {
        // when, then
        val exception = assertThrows<IllegalArgumentException> { LottoNumber(number) }
        assertEquals("로또 숫자는 1 이상 45 이하이어야 합니다. (number: $number)", exception.message)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun `로또 숫자 정상 생성`(number: Int) {
        // when
        val lottoNumber = LottoNumber(number)

        // then
        assertEquals(lottoNumber.number, number)
    }
}
