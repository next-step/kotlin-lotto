package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveNumber
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SixFortyFiveNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 11, 21, 31, 41, 45])
    fun `1 ~ 45사이의 수를 가질 수 있습니다`(number: Int) {
        Assertions.assertEquals(number, SixFortyFiveNumber(number).value)
    }

    @ParameterizedTest
    @ValueSource(ints = [47, 0, 132])
    fun `1 ~ 45사이의 수가 아니면 에러를 발생합니다`(number: Int) {
        assertThrows<RuntimeException>(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER.msg) {
            SixFortyFiveNumber(number)
        }
    }
}
