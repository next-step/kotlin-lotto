package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest {
    @Test
    fun `로또는 중복 없는 6개의 숫자로 만들 수 있다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)

        val lotto = Lotto(numbers)

        assertThat(lotto.numbers.map { it.value }).isEqualTo(listOf(1, 2, 3, 4, 5, 6))
    }

    @Test
    fun `로또 번호가 6개가 아니면 안된다`() {
        val numbers = listOf(1)

        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `로또 번호는 중복이 있으면 안된다`() {
        val numbers = listOf(1, 1, 1, 1, 1, 1)

        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `보너스 번호도 다른 번호와 중복될 수 없다`() {
        val numbers = listOf(1, 1, 1, 1, 1, 7)

        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `로또 번호는 1보다 작은게 있으면 안된다`() {
        val numbers = listOf(0, 1, 1, 1, 1, 1)

        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `로또 번호는 45보다 크면 안된다`() {
        val numbers = listOf(46, 1, 1, 1, 1, 1)

        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @Test
    fun `로또 번호는 정렬되어 있지 않으면 안된다`() {
        val numbers = listOf(6, 5, 4, 3, 2, 1)

        assertThrows<IllegalArgumentException> {
            Lotto(numbers)
        }
    }

    @ParameterizedTest
    @MethodSource("provideLotto")
    fun `당첨 번호가 포함되어있으면 Winning 값을 변경해준다`(lotto: Lotto, expectedWinning: LottoWinning) {
        val winningLotto = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(7))
        val checkedLotto = lotto.match(winningLotto)

        val actualWinning = checkedLotto.winning

        assertThat(actualWinning).isEqualTo(expectedWinning)
    }

    companion object {
        @JvmStatic
        private fun provideLotto(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Lotto(listOf(1, 2, 3, 10, 11, 12)), LottoWinning.Fifth),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 11, 12)), LottoWinning.Fourth),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 12)), LottoWinning.Third),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 7)), LottoWinning.Second),
                Arguments.of(Lotto(listOf(1, 2, 3, 4, 5, 6)), LottoWinning.First),
            )
        }
    }
}
