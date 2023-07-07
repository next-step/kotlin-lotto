package lotto.domain

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ValueSource(ints = [-1, 0, 46])
    @ParameterizedTest
    fun `로또번호 생성에 실패한다`(number: Int) {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoNumber(number)
        }
    }

}
