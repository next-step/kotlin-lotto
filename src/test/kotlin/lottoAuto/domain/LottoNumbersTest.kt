package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {
    @Test
    fun `6개 이상의 로또 번호가 들어올 경우 IllegalArgumentException을 발생시킨다`() {
        // given
        val numOfLottoNumber = 10

        assertThrows<IllegalArgumentException> { // then
            LottoNumbers( // when
                List(numOfLottoNumber) { LottoNumber.from(0) }
            )
        }
    }

    @Test
    fun `두 개의 LottoNumbers에서 중복된 숫자를 카운트한다`() {
        // given
        val lottoNumbers1 = LottoNumbers(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6)
            )
        )
        val lottoNumbers2 = LottoNumbers(
            listOf(
                LottoNumber.from(10),
                LottoNumber.from(20),
                LottoNumber.from(30),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
            )
        )

        // when
        val matchedCount = lottoNumbers1.countSameNumber(lottoNumbers2)

        // then
        assertEquals(3, matchedCount)
    }
}
