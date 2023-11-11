package lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoTest{

    @Test
    fun `로또 번호를 생성한다`(){
        val lotto = Lotto(listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6)
        ))
        assertEquals(lotto.numbers.size, Lotto.LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `로또 번호는 6개여야 한다`(){
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5)
            ))
        }
    }

    @Test
    fun `로또 번호는 중복될 수 없다`(){
        assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(5)
            ))
        }
    }
}
