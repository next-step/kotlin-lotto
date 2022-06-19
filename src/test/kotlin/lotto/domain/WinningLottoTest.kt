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
    fun `숫자가 6개가 아닌 로또는 생성불가`(lottoNumbers: List<LottoNumber>) {
        assertThrows<IllegalArgumentException> { WinningLotto.create(lottoNumbers) }
            .shouldHaveMessage("로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다.")
    }

    @ParameterizedTest
    @MethodSource
    fun `중복된 숫자를 가진 로또는 생성 불가`(lottoNumbers: List<LottoNumber>) {
        assertThrows<IllegalArgumentException> { WinningLotto.create(lottoNumbers) }
            .shouldHaveMessage("로또 숫자는 중복될 수 없습니다.")
    }

    @Test
    fun `로또 결과 및 수익률 계산`() {
        val winningLotto = WinningLotto.create(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
            )
        )

        val firstLotto = Lotto.create(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(6),
            )
        )

        val secondLotto = Lotto.create(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(4),
                LottoNumber.from(5),
                LottoNumber.from(7),
            )
        )

        val fourthLotto = Lotto.create(
            listOf(
                LottoNumber.from(1),
                LottoNumber.from(2),
                LottoNumber.from(3),
                LottoNumber.from(7),
                LottoNumber.from(8),
                LottoNumber.from(9),
            )
        )

        val noPrizeLotto = Lotto.create(
            listOf(
                LottoNumber.from(10),
                LottoNumber.from(11),
                LottoNumber.from(12),
                LottoNumber.from(7),
                LottoNumber.from(8),
                LottoNumber.from(9),
            )
        )

        val result = winningLotto.calculateProfit(listOf(firstLotto, secondLotto, fourthLotto, noPrizeLotto))
        assertThat(result.first).containsExactly(6, 5, 3, 0)
        assertThat(result.second).isEqualTo(500376.25)
    }

    companion object {
        @JvmStatic
        fun `숫자가 6개가 아닌 로또는 생성불가`(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(
                    listOf(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                    ),
                    listOf(
                        LottoNumber.from(1),
                        LottoNumber.from(2),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(6),
                        LottoNumber.from(7),
                    )
                )
            )
        }

        @JvmStatic
        fun `중복된 숫자를 가진 로또는 생성 불가`(): Stream<Arguments> {
            return Stream.of(
                Arguments.arguments(
                    listOf(
                        LottoNumber.from(1),
                        LottoNumber.from(1),
                        LottoNumber.from(3),
                        LottoNumber.from(4),
                        LottoNumber.from(5),
                        LottoNumber.from(6),
                    ),
                    listOf(
                        LottoNumber.from(6),
                        LottoNumber.from(6),
                        LottoNumber.from(6),
                        LottoNumber.from(6),
                        LottoNumber.from(6),
                        LottoNumber.from(6),
                    )
                )
            )
        }
    }
}
