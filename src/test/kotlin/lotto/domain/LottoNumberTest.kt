package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class LottoNumberTest {

    @Test
    fun `1부터 45사이 외의 숫자는 생성되면 안된다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoNumber.from(46)
        }
    }
}
