package lotto.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class WinningLottoTest {

    @Test
    fun notSixNumberWinningLottos() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                ),
                LottoNumber(6)
            )
        }
            .shouldHaveMessage("로또 숫자가 6개가 아닌 로또는 생성할 수 없습니다.")
    }

    @Test
    fun duplicatedNumberWinningLottos() {
        assertThrows<IllegalArgumentException> {
            WinningLotto(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                ),
                LottoNumber(6)
            )
        }
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
}
