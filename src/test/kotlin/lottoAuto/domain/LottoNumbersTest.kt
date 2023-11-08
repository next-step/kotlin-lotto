package lottoAuto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {
    @Test
    fun `6개 이상의 로또 번호가 들어올 경우 IllegalArgumentException을 발생시킨다`() {
        // given
        val numOfLottoNumber = 10

        assertThrows<IllegalArgumentException> { // then
            LottoNumbers( // when
                List(numOfLottoNumber) {LottoNumber.of(0)}
            )
        }

    }
}
