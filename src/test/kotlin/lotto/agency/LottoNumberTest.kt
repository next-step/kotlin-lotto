package lotto.agency

import lotto.agency.number.LottoNumber
import lotto.exception.LottoNumberPolicyException
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또 시작 번호에 대한 생성 테스트`() {
        val lottoStartNumber = LottoNumber(1)

        Assertions.assertThat(lottoStartNumber.number).isEqualTo(1)
    }

    @Test
    fun `로또 중간 번호에 대한 생성 테스트`() {
        val lottoStartNumber = LottoNumber(25)

        Assertions.assertThat(lottoStartNumber.number).isEqualTo(25)
    }

    @Test
    fun `로또 마지막 번호에 대한 생성 테스트`() {
        val lottoStartNumber = LottoNumber(45)

        Assertions.assertThat(lottoStartNumber.number).isEqualTo(45)
    }

    @Test
    fun `음수에 대한 실패 테스트`() {
        Assertions.assertThatThrownBy { LottoNumber(-1) }
            .isInstanceOf(LottoNumberPolicyException::class.java)
    }

    @Test
    fun `45번을 넘어갔을 때의 실패 테스트`() {
        Assertions.assertThatThrownBy { LottoNumber(46) }
            .isInstanceOf(LottoNumberPolicyException::class.java)
    }
}
