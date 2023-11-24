package me.parker.nextstep.kotlinlotto.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DataValueClassTest {

    @Test
    fun `data class 테스트`() {
        val lottoNumber1 = LottoNumberData(1)
        val lottoNumber2 = LottoNumberData(1)
        println(lottoNumber1)
        println(lottoNumber2)

        assertThat(lottoNumber1).isEqualTo(lottoNumber2)   // success
//        assertThat(lottoNumber1).isSameAs(lottoNumber2)     // fail

        val copyLottoNumber = lottoNumber1.copy()

        assertThat(lottoNumber1).isEqualTo(copyLottoNumber)   // success
        assertThat(lottoNumber2).isEqualTo(copyLottoNumber)   // success
    }

    @Test
    fun `value class 테스트`() {
        val lottoNumber1 = LottoNumberValue(1)
        val lottoNumber2 = LottoNumberValue(1)
        println(lottoNumber1)
        println(lottoNumber2)

        assertThat(lottoNumber1).isEqualTo(lottoNumber2)   // success
//        assertThat(lottoNumber1).isSameAs(lottoNumber2)     // fail

//        val copyLottoNumber = lottoNumber1.copy()         // 제공하지 않음.
    }
}
