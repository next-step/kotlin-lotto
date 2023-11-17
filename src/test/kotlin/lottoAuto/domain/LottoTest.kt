package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `동일한 LottoNumber로 구성된 두 개의 로또가 서로 같은지 확인한다`() {
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
                LottoNumber.from(4),
                LottoNumber.from(2),
                LottoNumber.from(6),
                LottoNumber.from(1),
                LottoNumber.from(3),
                LottoNumber.from(5),
            )
        )
        val lotto1 = Lotto(lottoNumbers1)
        val lotto2 = Lotto(lottoNumbers2)

        // when
        val isMatched = lotto1.match(lotto2)

        // then
        assertEquals(true, isMatched)
    }

    @Test
    fun `동일하지 않은 번호로 구성된 두 개의 로또가 서로 다른지 확인한다`() {
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
                LottoNumber.from(40),
                LottoNumber.from(45),
                LottoNumber.from(45),
            )
        )
        val lotto1 = Lotto(lottoNumbers1)
        val lotto2 = Lotto(lottoNumbers2)

        // when
        val isMatched = lotto1.match(lotto2)

        // then
        assertEquals(false, isMatched)
    }
}
