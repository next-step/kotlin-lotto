package lottoAuto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `동일한 LottoNumber로 구성된 두 개의 로또가 서로 같은지 확인한다`() {
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
                LottoNumber.of(4),
                LottoNumber.of(2),
                LottoNumber.of(6),
                LottoNumber.of(1),
                LottoNumber.of(3),
                LottoNumber.of(5),
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
                LottoNumber.of(40),
                LottoNumber.of(45),
                LottoNumber.of(45),
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

