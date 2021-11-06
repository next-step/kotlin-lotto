package lotto.domain

import lotto.exception.IllegalLottoException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertAll

internal class LottoTest {
    @TestFactory
    fun `잘못된 로또번호 갯수`() = listOf(emptyList(), (1..5), (1..7), (1..43))
        .map {
            DynamicTest.dynamicTest("로또는 6개의 번호를 가져야 한다. $it") {
                assertThatExceptionOfType(IllegalLottoException::class.java)
                    .isThrownBy { Lotto.from(it.toList()) }
            }
        }

    @TestFactory
    fun `중복된 로또번호`() = listOf(listOf(1, 1, 2, 3, 4, 5), listOf(41, 42, 43, 43, 44, 40))
        .map {
            DynamicTest.dynamicTest("로또의 번호는 중복될 수 없다. $it") {
                assertThatExceptionOfType(IllegalLottoException::class.java)
                    .isThrownBy { Lotto.from(it) }
            }
        }

    @TestFactory
    fun equals() = listOf((1..6), (21..26), (30..35))
        .map {
            DynamicTest.dynamicTest("로또가 같으면 같다고 인식되어야 한다. $it") {
                assertThat(Lotto(it.map { number -> LottoNumber(number) }))
                    .isEqualTo(Lotto.from(it.toList()))
            }
        }

    @DisplayName("로또가 특정 로또번호를 가지고 있다면 True 를 반환한다.")
    @Test
    fun containsTrue() {
        val numbers = (1..6)
        val lotto = Lotto.from(numbers.toList())
        assertAll(numbers.map { { assertThat(lotto.contains(LottoNumber(it))).isTrue } })
    }

    @DisplayName("로또가 특정 로또번호를 가지고 있지 않다면 False 를 반환한다.")
    @Test
    fun containsFalse() {
        val numbers = (11..16)
        val lotto = Lotto.from(numbers.toList())
        assertAll(numbers.map { it + 10 }.map { { assertThat(lotto.contains(LottoNumber(it))).isFalse } })
    }

    @DisplayName("같은 로또번호의 갯수를 알수 있어야 한다.")
    @Test
    fun count() {
        assertThat(Lotto.from((1..6).toList()).countSameNumbers(Lotto.from((4..9).toList())))
            .isEqualTo(3)
    }
}
