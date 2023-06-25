package lotto.domain

import io.kotest.matchers.shouldBe
import lotto.domain.model.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.Prize
import lotto.domain.model.SelectedBalls
import lotto.domain.model.WinningBalls
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun `당첨 번호가 3개 일치하면 THREE_MATCH 당첨이다`() {
        val numbers = (1..6).map { LottoNumber.from(it) }
        val lotto = Lotto(numbers)
        val winningNumbers = listOf(1, 2, 3, 10, 11, 12).map { LottoNumber.from(it) }

        val bonus = 13

        val selectedBalls = SelectedBalls(WinningBalls(winningNumbers), LottoNumber.from(bonus))

        Prize.from(selectedBalls, lotto) shouldBe Prize.THREE_MATCH
    }

    @Test
    fun `당첨 번호가 4개 일치하면 FOUR_MATCH 당첨이다`() {
        val numbers = (1..6).map { LottoNumber.from(it) }
        val lotto = Lotto(numbers)
        val winningNumbers = listOf(1, 2, 3, 4, 10, 11).map { LottoNumber.from(it) }

        val bonus = 12

        val selectedBalls = SelectedBalls(WinningBalls(winningNumbers), LottoNumber.from(bonus))

        Prize.from(selectedBalls, lotto) shouldBe Prize.FOUR_MATCH
    }

    @Test
    fun `당첨 번호가 5개 일치하면 FIVE_MATCH 당첨이다`() {
        val numbers = (1..6).map { LottoNumber.from(it) }
        val lotto = Lotto(numbers)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 10).map { LottoNumber.from(it) }

        val bonus = 11

        val selectedBalls = SelectedBalls(WinningBalls(winningNumbers), LottoNumber.from(bonus))

        Prize.from(selectedBalls, lotto) shouldBe Prize.FIVE_MATCH
    }

    @Test
    fun `당첨 번호가 5개 일치하고 보너스볼이 일치하면 FIVE_MATCH_PLUS_BONUS 당첨이다`() {
        val numbers = (1..6).map { LottoNumber.from(it) }
        val lotto = Lotto(numbers)
        val winningNumbers = listOf(1, 2, 3, 4, 5, 10).map { LottoNumber.from(it) }

        val bonus = 6

        val selectedBalls = SelectedBalls(WinningBalls(winningNumbers), LottoNumber.from(bonus))

        Prize.from(selectedBalls, lotto) shouldBe Prize.FIVE_MATCH_PLUS_BONUS
    }

    @Test
    fun `당첨 번호가 6개 일치하면 SIX_MATCH 당첨이다`() {
        val numbers = (1..6).map { LottoNumber.from(it) }
        val lotto = Lotto(numbers)
        val winningNumbers = (1..6).map { LottoNumber.from(it) }

        val bonus = 6

        val selectedBalls = SelectedBalls(WinningBalls(winningNumbers), LottoNumber.from(bonus))

        Prize.from(selectedBalls, lotto) shouldBe Prize.SIX_MATCH
    }
}
