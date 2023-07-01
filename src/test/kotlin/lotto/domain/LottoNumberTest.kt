package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [46, 0])
    fun `당첨 번호가 1부터 45 사이의 값이 아니면 IllegalArgumentException을 throw한다`(input: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber(input)
        }
    }
}
