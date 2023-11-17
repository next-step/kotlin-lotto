package lottoAuto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호가 6개가 아닐 경우 로또 생성 시 IllegalArgumentException을 발생시킨다`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
        )

        assertThrows<IllegalArgumentException> { // then
            Lotto(lottoNumbers) // when
        }
    }

    @Test
    fun `중복된 로또 번호가 들어왔을 경우 IllegalArgumentException을 발생시킨다`() {
        // given
        val lottoNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
        )

        assertThrows<IllegalArgumentException> { // then
            Lotto(lottoNumbers) // when
        }
    }
}
