package lottoAuto.domain

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
    fun `getSortedLottoNumbers 함수를 호출할 경우 number 기준으로 정렬된 LottoNumber를 반환한다`() {
        // given
        val lottoNumbers = LottoNumbers(
            listOf(
                LottoNumber.of(3),
                LottoNumber.of(2),
                LottoNumber.of(1),
                LottoNumber.of(6),
                LottoNumber.of(5),
                LottoNumber.of(4)
            )
        )
        val expectedLottoNumbers = listOf(
            LottoNumber.of(1),
            LottoNumber.of(2),
            LottoNumber.of(3),
            LottoNumber.of(4),
            LottoNumber.of(5),
            LottoNumber.of(6)
        )

        // when
        val sortedLottoNumbers = lottoNumbers.getSortedLottoNumbers()

        // then
        assertIterableEquals(expectedLottoNumbers, sortedLottoNumbers)
    }
}
