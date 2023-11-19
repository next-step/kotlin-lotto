package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun `주어진 로또 번호가 1 미만이거나 45를 초과했을 경우 IllegalArgumentException을 발생시킨다`() {
        // given
        val number = 0

        assertThrows<IllegalArgumentException> { // then
            number.toLottoNumber() // when
        }
    }

    @Test
    fun `동일한 로또 번호가 주어질 경우 캐싱된 객체를 가져오는지 확인한다`() {
        // given
        val number1 = 1
        val number2 = 1

        // when
        val lottoNumber1 = number1.toLottoNumber()
        val lottoNumber2 = number2.toLottoNumber()

        // then
        assertEquals(lottoNumber1, lottoNumber2)
        assertSame(lottoNumber1, lottoNumber2)
    }
}
