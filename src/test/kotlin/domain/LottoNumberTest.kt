package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumberTest {
    @Test
    fun createLottoNumberMin() {
        val lottoNumber = LottoNumber(1)
        assertThat(lottoNumber.number).isEqualTo(1)
    }

    @Test
    fun createLottoNumberMax() {
        val lottoNumber = LottoNumber(45)
        assertThat(lottoNumber.number).isEqualTo(45)
    }

    @Test
    fun throwCreateLottoNumberMin() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @Test
    fun throwCreateLottoNumberMax() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }
}
