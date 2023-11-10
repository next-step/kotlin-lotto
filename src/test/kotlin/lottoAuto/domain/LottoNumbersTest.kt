package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
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

    @Test
    fun `두 개의 LottoNumbers에서 중복된 숫자를 카운트한다`() {
        // given
        val lottoNumbers1 = LottoNumbers(
            listOf(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
            )
        )
        val lottoNumbers2 = LottoNumbers(
            listOf(
                LottoNumber.of(10),
                LottoNumber.of(20),
                LottoNumber.of(30),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
            )
        )

        // when
        val matchedCount = lottoNumbers1.countSameNumber(lottoNumbers2)

        // then
        assertEquals(3, matchedCount)
    }
}
