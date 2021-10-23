package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `로또는 6개 로또 번호를 가지고 있다`() {
        val lottoNumber1 = LottoNumber.valueOf(1)
        val lottoNumber2 = LottoNumber.valueOf(2)
        val lottoNumber3 = LottoNumber.valueOf(3)
        val lottoNumber4 = LottoNumber.valueOf(4)
        val lottoNumber5 = LottoNumber.valueOf(5)
        val lottoNumber6 = LottoNumber.valueOf(6)
        val lottoNumbers = listOf(
            lottoNumber1, lottoNumber2, lottoNumber3,
            lottoNumber4, lottoNumber5, lottoNumber6
        )

        val lotto = Lotto(lottoNumbers)
        assertThat(lotto.lottoNumbers).hasSize(6)
    }

    @Test
    fun `로또는 로또갯수가 올바르지 않으면 예외를 던진다`() {
        val lottoNumber1 = LottoNumber.valueOf(1)
        val lottoNumber2 = LottoNumber.valueOf(2)
        val lottoNumber3 = LottoNumber.valueOf(3)

        val lottoNumbers = listOf(
            lottoNumber1, lottoNumber2, lottoNumber3
        )

        assertThatCode { Lotto(lottoNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
