package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class LottoTest {
    private val number1 = LottoNumber.of(1)
    private val number2 = LottoNumber.of(2)
    private val number3 = LottoNumber.of(3)
    private val number4 = LottoNumber.of(4)
    private val number5 = LottoNumber.of(5)
    private val number6 = LottoNumber.of(6)
    private val number7 = LottoNumber.of(7)

    @Test
    fun `1개의 로또는 서로 다른 6개의 로또 넘버로 이루어져 있다 정상 생성`() {
        assertDoesNotThrow {
            Lotto(setOf(number1, number2, number3, number4, number5, number6))
        }
    }

    @Test
    fun `로또 넘버가 6개가 아닐 경우 넘버 5개`() {
        assertThrows<IllegalArgumentException> {
            Lotto(setOf(number1, number2, number3, number4, number5))
        }
    }

    @Test
    fun `로또 넘버가 6개가 아닐 경우 넘버 7개`() {
        assertThrows<IllegalArgumentException> {
            Lotto(setOf(number1, number2, number3, number4, number5, number6, number7))
        }
    }

    @Test
    fun `로또 한장의 가격은 1000원이다`() {
        assertThat(Lotto.PRICE).isEqualTo(Money(1000))
    }

    @Test
    fun `로또 맞는 갯수`() {
        val lotto1 = Lotto(setOf(number1, number2, number3, number4, number5, number6))
        val lotto2 = Lotto(setOf(number1, number2, number3, number4, number5, number6))

        assertThat(lotto1.matchCount(lotto2)).isEqualTo(6)
    }

    @Test
    fun `로또에 같은 로또 넘버가 있는지`() {
        val lotto = Lotto(setOf(number1, number2, number3, number4, number5, number6))
        assertThat(number1 in lotto).isTrue()
    }

    @Test
    fun `로또에 같은 로또 넘버가 없는지`() {
        val lotto = Lotto(setOf(number1, number2, number3, number4, number5, number6))
        assertThat(number7 in lotto).isFalse()
    }
}
