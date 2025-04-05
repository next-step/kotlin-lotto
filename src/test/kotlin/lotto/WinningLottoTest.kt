package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningLottoTest {
    @Test
    fun `WinningLotto should have a lotto and a lotto number as a bonus number`() {
        // given
        val lottoNumbers = (1..6).map { LottoNumber.of(it) }
        val bonusNumber = LottoNumber.of(7)

        // when && then
        assertDoesNotThrow { WinningLotto(Lotto(lottoNumbers), bonusNumber) }
    }

    @Test
    fun `Throw exception when winning lotto has bonus number`() {
        // given
        val lottoNumbers = (1..6).map { LottoNumber.of(it) }
        val bonusNumber = LottoNumber.of(6)

        // when && then
        assertThrows<IllegalArgumentException> { WinningLotto(Lotto(lottoNumbers), bonusNumber) }
    }

    @Test
    fun `Return true when lotto has bonus number`() {
        // given
        val lotto = Lotto((7..12).map { LottoNumber.of(it) })
        val lottoNumbers = (1..6).map { LottoNumber.of(it) }
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(Lotto(lottoNumbers), bonusNumber)
        val expected = true

        // when
        val actual = winningLotto.containBonusNumber(lotto)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("provideMatchNumbers")
    fun `Return how many numbers are matched in WinningLotto with other`(
        lottoNumbers: List<Int>,
        matchCount: Int,
    ) {
        // given
        val numbers = (1..6).map { LottoNumber.of(it) }
        val bonusNumber = LottoNumber.of(7)
        val winningLotto = WinningLotto(Lotto(numbers), bonusNumber)

        val lotto = Lotto(lottoNumbers.map { LottoNumber.of(it) })

        // when
        val actual = winningLotto.matchCount(lotto)

        // then
        assertThat(actual).isEqualTo(matchCount)
    }

    companion object {
        @JvmStatic
        fun provideMatchNumbers(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(listOf(1, 2, 3, 4, 5, 7), 5),
                Arguments.of(listOf(1, 2, 3, 4, 8, 7), 4),
                Arguments.of(listOf(1, 2, 3, 9, 8, 7), 3),
                Arguments.of(listOf(1, 2, 10, 9, 8, 7), 2),
                Arguments.of(listOf(1, 11, 10, 9, 8, 7), 1),
                Arguments.of(listOf(12, 11, 10, 9, 8, 7), 0),
            )
    }
}
