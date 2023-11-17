package lottoAuto.domain

import lottoAuto.domain.LottoNumber.Companion.toLottoNumber
import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun `withBonusNumber 테스트`() {
        // given
        val lottoNumbers = listOf(
            1.toLottoNumber(),
            2.toLottoNumber(),
            3.toLottoNumber(),
            4.toLottoNumber(),
            5.toLottoNumber(),
            6.toLottoNumber()
        )

        // when
        val withBonus = Lotto(lottoNumbers).withBonusNumber(5.toLottoNumber())
        val withNoBonus = Lotto(lottoNumbers).withBonusNumber(7.toLottoNumber())

        // then
        assertEquals(true, withBonus)
        assertEquals(false, withNoBonus)
    }
}
