package lotto.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class WinningLottoTest {

    @ParameterizedTest
    @MethodSource
    fun `숫자가 6개가 아닌 로또는 생성불가`(lottoNumbers: List<LottoNumber>, bonusNumber: LottoNumber) {
        assertThrows<IllegalArgumentException> { WinningLotto(lottoNumbers, bonusNumber) }
            .shouldHaveMessage("로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다.")
    }

    @ParameterizedTest
    @MethodSource
    fun `중복된 숫자를 가진 로또는 생성 불가`(lottoNumbers: List<LottoNumber>, bonusNumber: LottoNumber) {
        assertThrows<IllegalArgumentException> { WinningLotto(lottoNumbers, bonusNumber) }
            .shouldHaveMessage("로또 숫자는 중복될 수 없습니다.")
    }

    @Test
    fun `로또 결과 및 수익률 계산`() {
        val winningLotto = WinningLotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            ),
            LottoNumber(7)
        )

        val firstLotto = Lotto.create(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )

        val bonusLotto = Lotto.create(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7),
            )
        )

        val fourthLotto = Lotto.create(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(7),
                LottoNumber(8),
                LottoNumber(9),
            )
        )

        val noPrizeLotto = Lotto.create(
            listOf(
                LottoNumber(10),
                LottoNumber(11),
                LottoNumber(12),
                LottoNumber(7),
                LottoNumber(8),
                LottoNumber(9),
            )
        )

        val result = winningLotto.calculateProfit(listOf(firstLotto, bonusLotto, fourthLotto, noPrizeLotto))
        assertThat(result.first).containsExactly(LottoRank.FIRTH, LottoRank.BONUS, LottoRank.FOURTH, LottoRank.DEFAULT)
        assertThat(result.second).isEqualTo(507501.25)
    }

    companion object {
        @JvmStatic
        fun `숫자가 6개가 아닌 로또는 생성불가`(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                    ),
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                        LottoNumber(7),
                    )
                )
            )
        }

        @JvmStatic
        fun `중복된 숫자를 가진 로또는 생성 불가`(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(1),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                    LottoNumber(7),
                ),
                Arguments.arguments(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                    ),
                    LottoNumber(6),
                )
            )
        }
    }
}
