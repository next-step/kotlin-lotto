package lotto.domain

import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `lottoNumbers 생성에 성공한다`() {
        // expect
        assertThatNoException().isThrownBy {
            LottoNumbers(
                setOf(
                    LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4),
                    LottoNumber(5), LottoNumber(6)
                )
            )
        }
    }
}
