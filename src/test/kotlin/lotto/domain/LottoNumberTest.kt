package lotto.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumberTest {
    @ParameterizedTest
    @CsvSource("1, 1", "2, 2", "3, 3")
    fun `from은 동일한 수를 내보낸다`(param: Int, expected: String) {
        assertThat(LottoNumber.from(param).toString()).isEqualTo(expected)
    }

    @Test
    fun `from은 1~45만 가능하다`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { LottoNumber.from(46) }
            .withMessage("로또 숫자는 1부터 45만 가능합니다.")
    }
}
