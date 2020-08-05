package lotto.domain.value

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoNumberTest {
    @Test
    fun zeroTest() {
        assertThatThrownBy { (LottoNumber(0)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또는 1~45사이의 숫자만 생성가능합니다.")
    }

    @Test
    fun `46Test`() {
        assertThatThrownBy { (LottoNumber(46)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("로또는 1~45사이의 숫자만 생성가능합니다.")
    }

    @Test
    fun normalTest() {
        for (i in 1..45) {
            assertThat(LottoNumber(i)).isEqualTo(LottoNumber(i))
        }
    }

    @Test
    fun getNumber() {
        val testNumber = 16
        val lottoNumber = LottoNumber(testNumber)
        val actual = lottoNumber.getNumber()
        assertThat(actual).isEqualTo(testNumber)
    }

    @Test
    fun toStringTest() {
        val testNumber = 16
        val actual = LottoNumber(testNumber).toString()
        assertThat(actual).isEqualTo(testNumber.toString())
    }
}
