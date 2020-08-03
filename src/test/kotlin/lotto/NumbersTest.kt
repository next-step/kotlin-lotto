package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class NumbersTest {

    @Test
    fun `1~45사이 6개의 숫자 객체 생성(성공)`() {
        val lottoNumber = LottoNumber(1, 2, 3, 4, 5, 6)
        assertThat(lottoNumber.numbers).contains(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `1~45 이외의 숫자 객체 생성(예외)`() {
        assertThrows<IllegalArgumentException> {
            val lottoNumber = LottoNumber(1, 2, 3, 0, 5, 6)
        }

        assertThrows<IllegalArgumentException> {
            val lottoNumber = LottoNumber(1, 2, 3, 50, 5, 6)
        }
    }

    @Test
    fun `6개가 아닌 숫자 목록 생성(예외)`() {
        assertThrows<IllegalArgumentException> {
            val lottoNumber = LottoNumber(1, 2, 35, 4, 6)
        }

        assertThrows<IllegalArgumentException> {
            val lottoNumber = LottoNumber(1, 2, 3, 2, 5, 6, 8)
        }
    }

    @Test
    fun `중복된 숫자 목록 생성(예외)`() {
        assertThrows<IllegalArgumentException> {
            val lottoNumber = LottoNumber(1, 2, 35, 4, 6, 2)
        }
    }
}
