package lottoAuto.domain

import lottoAuto.domain.LottoNumber.Companion.toLottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호가 6개가 아닐 경우 로또 생성 시 IllegalArgumentException을 발생시킨다`() {
        // given
        val lottoNumbers = listOf(
            1.toLottoNumber(),
            2.toLottoNumber(),
            3.toLottoNumber(),
            4.toLottoNumber(),
            5.toLottoNumber()
        )

        assertThrows<IllegalArgumentException> { // then
            Lotto(lottoNumbers) // when
        }
    }

    @Test
    fun `중복된 로또 번호가 들어왔을 경우 IllegalArgumentException을 발생시킨다`() {
        // given
        val lottoNumbers = listOf(
            1.toLottoNumber(),
            1.toLottoNumber(),
            2.toLottoNumber(),
            3.toLottoNumber(),
            4.toLottoNumber()
        )

        assertThrows<IllegalArgumentException> { // then
            Lotto(lottoNumbers) // when
        }
    }
}
