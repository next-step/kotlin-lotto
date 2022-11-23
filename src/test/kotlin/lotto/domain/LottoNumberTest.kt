package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `잘못된 범위의 로또 번호 입력시 예외 발생한다`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(number) }
    }
}
