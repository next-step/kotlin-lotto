package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `Lotto객체생성`() {
        val lottoNumbers = hashSetOf(
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(1),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        )

        val lotto = Lotto(lottoNumbers)

        assertThat(lotto.get.size).isEqualTo(6)
    }

    @Test
    fun `Lotto 유효성 검증`() {
        val lottoNumbers = hashSetOf(
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
