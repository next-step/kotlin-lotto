package lotto.domain.value

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PriceTest{
    @Test
    fun `비율을 구한다`(){
        //given
        val base = Price(100)
        val target = Price(53)

        //when
        val rate = target.rate(base)

        //then
        assertThat(rate).isEqualTo(0.53)
    }

    @Test
    fun `나누기`(){
        //given
        val price = Price(100)

        //when
        val result = price/ 2

        //then
        assertThat(result).isEqualTo(50)
    }

    @Test
    fun `빼기`(){
        //given
        val price = Price(100)

        //when
        val result = price - Price(2)

        //then
        assertThat(result).isEqualTo(Price(98))
    }
}
