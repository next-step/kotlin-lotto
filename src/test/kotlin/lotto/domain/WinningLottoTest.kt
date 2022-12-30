package lotto.domain

import lotto.model.LottoNumber
import lotto.model.LottoNumbers
import lotto.model.Rank
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class WinningLottoTest {
    private val winningLottoNumbers = (1..6).map(::LottoNumber)
    private val bonusNumber = LottoNumber(7)
    private val winningLotto = WinningLotto(winningLottoNumbers, bonusNumber)

    @Test
    fun `당첨 번호는 6개의 숫자로 구성된다`() {
        val bonusNumber = LottoNumber(7)
        val winningLotto = WinningLotto(winningLottoNumbers, bonusNumber)

        assertThat(winningLotto).isNotNull
    }

    @Test
    fun `담청 번호는 6개의 숫자가 아니면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5).map(::LottoNumber)

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(numbers, bonusNumber) }
            .withMessage("당첨 번호는 6개의 숫자여야 합니다.")
    }

    @Test
    fun `담청 번호는 중복되는 숫자가 있으면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 5).map(::LottoNumber)

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(numbers, bonusNumber) }
            .withMessage("당첨 번호는 중복되는 숫자가 없어야 합니다.")
    }

    @Test
    fun `당첨번호와 보너스 번호는 중복되면 예외가 발생한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
        val bonusNumber = LottoNumber(6)

        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { WinningLotto(numbers, bonusNumber) }
            .withMessage("당첨 번호와 보너스 번호는 중복되면 안됩니다.")
    }

    @Test
    fun `1등 당첨`() {
        // given
        val userLottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))

        // when
        val rank = winningLotto.rank(userLottoNumbers)

        // then
        assertThat(rank).isEqualTo(Rank.FIRST)
    }

    @Test
    fun `2등 당첨`() {
        // given
        val userLottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 7).map(::LottoNumber))

        // when
        val rank = winningLotto.rank(userLottoNumbers)

        // then
        assertThat(rank).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `3등 당첨`() {
        // given
        val userLottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 5, 8).map(::LottoNumber))

        // when
        val rank = winningLotto.rank(userLottoNumbers)

        // then
        assertThat(rank).isEqualTo(Rank.THIRD)
    }

    @Test
    fun `4등 당첨`() {
        // given
        val userLottoNumbers = LottoNumbers(listOf(1, 2, 3, 4, 8, 9).map(::LottoNumber))

        // when
        val rank = winningLotto.rank(userLottoNumbers)

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH)
    }

    @Test
    fun `5등 당첨`() {
        // given
        val userLottoNumbers = LottoNumbers(listOf(1, 2, 3, 8, 9, 10).map(::LottoNumber))

        // when
        val rank = winningLotto.rank(userLottoNumbers)

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH)
    }

    @ParameterizedTest
    @MethodSource("provideLosingLottoNumbers")
    fun `꽝(담청 결과 없음)`(userLottoNumbers: LottoNumbers) {
        val rank = winningLotto.rank(userLottoNumbers)

        assertThat(rank).isNull()
    }

    companion object {
        @JvmStatic
        fun provideLosingLottoNumbers(): Stream<LottoNumbers> {
            return Stream.of(
                LottoNumbers(listOf(1, 12, 13, 7, 8, 9).map(::LottoNumber)),
                LottoNumbers(listOf(1, 2, 13, 7, 8, 9).map(::LottoNumber)),
                LottoNumbers(listOf(11, 12, 13, 7, 8, 9).map(::LottoNumber))
            )
        }
    }
}
