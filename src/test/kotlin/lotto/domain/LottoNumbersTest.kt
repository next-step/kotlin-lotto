package lotto.domain

import org.assertj.core.api.Assertions.assertThatExceptionOfType
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

    @Test
    fun `lottoNumbers 가 6개가 아닌 경우 생성에 실패한다`() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoNumbers(setOf(LottoNumber(1)))
        }
    }
}
