package lotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoNumber
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SixFortyFiveLottoNumberTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,3,5,7,43,45", "32,35,37,42,44,45", "1,17,22,29,43,44"])
    fun `1 ~ 45사이의 중복되지 않는 6개 수를 갖습니다`(numberStr: String) {
        val numbers = Utils.parseNumbersFromStr(numberStr, ',')

        SixFortyFiveLottoNumber(numbers)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,3,3,7,43,45", "32,35,37,37,44,45", "1,17,29,29,43,44"])
    fun `중복된 숫자를 가지면 에러를 발생합니다`(numberStr: String) {
        val numbers = Utils.parseNumbersFromStr(numberStr, ',')

        assertThrows<RuntimeException>(ErrorCode.INVALID_SIX_FORTY_FIVE_LOTTO_NUMBER.msg) {
            SixFortyFiveLottoNumber(numbers)
        }
    }
}
