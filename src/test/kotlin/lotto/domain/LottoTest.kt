package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoTest {

    @Test
    fun `로또는 6개의 로또 넘버를 가진다`() {
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        assertThat(lotto.numbers).hasSize(6)
    }

    @ParameterizedTest
    @MethodSource("lottoArguments")
    fun `Lotto 당첨 번호가 몇개가 맞았는지 알 수 있다`(lotto: Lotto, winningLotto: Lotto, matched: Int) {
        val result = lotto.countOfMatch(winningLotto)

        assertThat(result).isEqualTo(matched)
    }

    @Test
    fun `중복된 숫자가 입력되면 exception`() {
        assertThrows<IllegalArgumentException> {
            Lotto(1, 1, 1, 1, 1, 1)
        }
    }

    @Test
    fun `로또 숫자가 6개보다 부족하면 exception`() {
        assertThrows<IllegalArgumentException> {
            Lotto(1, 2, 3, 4, 5)
        }
    }

    @Test
    fun `로또 숫자가 6개보다 많으면 exception`() {
        assertThrows<IllegalArgumentException> {
            Lotto(1, 2, 3, 4, 5, 6, 7)
        }
    }

    companion object {
        @JvmStatic
        fun lottoArguments(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Lotto(7, 8, 9, 10, 11, 12), 0),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Lotto(7, 8, 9, 10, 11, 12), 0),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 8, 9, 10, 11, 12), 1),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 2, 9, 10, 11, 12), 2),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 2, 3, 10, 11, 12), 3),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 2, 3, 4, 11, 12), 4),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 2, 3, 4, 5, 12), 5),
                Arguments.of(Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 2, 3, 4, 5, 6), 6),
            )
        }
    }
}
