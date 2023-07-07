package lotto.domain

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatNoException
import org.junit.jupiter.api.Test

class LottoNumbersTest {

    @Test
    fun `로또번호 생성에 성공한다`() {
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
    fun `로또번호가 중복되는 경우 실패한다`() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoNumbers(
                setOf(
                    LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4),
                    LottoNumber(5), LottoNumber(5)
                )
            )
        }
    }

    @Test
    fun `로또번호가 5개인 경우 실패한다`() {
        // expect
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoNumbers(
                setOf(
                    LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5),
                )
            )
        }
    }
}
