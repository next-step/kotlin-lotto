package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `1에서 45 사이의 숫자가의 로또 객체들을 생성`() {
        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val lotto = Lotto(lottoNumbers)

        assertThat(lotto.numbers.size).isEqualTo(6)
    }

    @Test
    fun `Lotto 유효성 검증`() {
        val lottoNumbers = setOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(1),
            LottoNumber(5),
            LottoNumber(6)
        )

        assertThatIllegalArgumentException()
            .isThrownBy { Lotto(lottoNumbers) }
    }
}
