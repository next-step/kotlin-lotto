package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test

internal class LottoTest {

    @Test
    fun `로또는 6개 로또 번호를 가지고 있다`() {
        val lottoNumbers = (1..6).map { LottoNumber.valueOf(it) }

        val lotto = Lotto(lottoNumbers)
        assertThat(lotto.getLottoNumbers()).hasSize(6)
    }

    @Test
    fun `로또는 로또 번호가 6개가 아니라면 예외를 던진다`() {
        val lottoNumbers = (1..5).map { LottoNumber.valueOf(it) }

        assertThatCode { Lotto(lottoNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `로또는 로또번호가 중복되면 예외를 던진다`() {
        val lottoNumber1 = LottoNumber.valueOf(1)
        val lottoNumber2 = LottoNumber.valueOf(1)
        val lottoNumber3 = LottoNumber.valueOf(1)
        val lottoNumber4 = LottoNumber.valueOf(2)
        val lottoNumber5 = LottoNumber.valueOf(2)
        val lottoNumber6 = LottoNumber.valueOf(2)
        val lottoNumbers = listOf(
            lottoNumber1, lottoNumber2, lottoNumber3,
            lottoNumber4, lottoNumber5, lottoNumber6
        )
        assertThatCode { Lotto(lottoNumbers) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `추출 번호는 오름차순으로 정렬되어 표시 된다`() {
        val lottoNumber1 = LottoNumber.valueOf(6)
        val lottoNumber2 = LottoNumber.valueOf(5)
        val lottoNumber3 = LottoNumber.valueOf(4)
        val lottoNumber4 = LottoNumber.valueOf(3)
        val lottoNumber5 = LottoNumber.valueOf(2)
        val lottoNumber6 = LottoNumber.valueOf(1)
        val lottoNumbers = listOf(
            lottoNumber1, lottoNumber2, lottoNumber3,
            lottoNumber4, lottoNumber5, lottoNumber6
        )

        val lotto = Lotto(lottoNumbers)

        assertThat(lotto.getLottoNumbers()).containsExactlyInAnyOrder(
            lottoNumber6, lottoNumber5,
            lottoNumber4, lottoNumber3,
            lottoNumber2, lottoNumber1
        )
    }
}
