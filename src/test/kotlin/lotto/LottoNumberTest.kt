package lotto

import lotto.domain.LottoNumber
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {

    @Test
    fun `로또 번호가 1에서 45사이가 아니라면 예외가 발생한다`() {
        listOf(0, 46).forEach {
            assertThrows<IllegalArgumentException>(message = "로또 번호는 1에서 45사이여야 합니다.",) {
                LottoNumber.of(it)
            }
        }
    }

    @Test
    fun `로또 번호가 1에서 45사이라면 예외가 발생하지 않는다`() {
        listOf(1, 45).forEach {
            LottoNumber.of(it)
        }
    }

    @Test
    fun `같은 숫자는 캐싱된 값을 사용한다`() {
        val lottoNumber1 = LottoNumber.of(1)
        val lottoNumber2 = LottoNumber.of(1)
        assert(lottoNumber1 == lottoNumber2)
    }
}