package lotto.domain

import lotto.exception.IllegalLottoException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

internal class LottoTest {
    @TestFactory
    fun `잘못된 로또번호 갯수`() = listOf(emptyList(), (1..5), (1..7), (1..45))
        .map {
            DynamicTest.dynamicTest("로또는 6개의 번호를 가져야 한다. $it") {
                assertThatExceptionOfType(IllegalLottoException::class.java)
                    .isThrownBy { Lotto.from(it.toList()) }
            }
        }

    @TestFactory
    fun `중복된 로또번호`() = listOf(listOf(1, 1, 2, 3, 4, 5), listOf(41, 42, 43, 43, 44, 45))
        .map {
            DynamicTest.dynamicTest("로또의 번호는 중복될 수 없다. $it") {
                assertThatExceptionOfType(IllegalLottoException::class.java)
                    .isThrownBy { Lotto.from(it) }
            }
        }

    @TestFactory
    fun equals() = listOf((1..6), (21..26), (40..45))
        .map {
            DynamicTest.dynamicTest("로또가 같으면 같다고 인식되어야 한다. $it") {
                assertThat(Lotto(it.map { number -> LottoNumber(number) }))
                    .isEqualTo(Lotto.from(it.toList()))
            }
        }

    @DisplayName("로또번호를 3개 맞추면 THREE 를 반환한다.")
    @Test
    fun threeMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 9, 8, 7))
        assertThat(lotto.checkMatch(Fixture.winningLotto))
            .isEqualTo(Match.THREE)
    }

    @DisplayName("로또번호를 4개 맞추면 FOUR 를 반환한다.")
    @Test
    fun fourMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 8, 7))
        assertThat(lotto.checkMatch(Fixture.winningLotto))
            .isEqualTo(Match.FOUR)
    }

    @DisplayName("로또번호를 5개 맞추면 FIVE 를 반환한다.")
    @Test
    fun fiveMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 7))
        assertThat(lotto.checkMatch(Fixture.winningLotto))
            .isEqualTo(Match.FIVE)
    }

    @DisplayName("로또번호를 6개 맞추면 SIX 를 반환한다.")
    @Test
    fun sixMatch() {
        val lotto = Lotto.from(listOf(1, 2, 3, 4, 5, 6))
        assertThat(lotto.checkMatch(Fixture.winningLotto))
            .isEqualTo(Match.SIX)
    }
}
