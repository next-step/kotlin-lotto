package lotto.rank

import io.kotest.matchers.shouldBe
import lotto.Lotto
import lotto.ball.BonusBall
import lotto.number.Numbers
import lotto.statistics.WinningNumber
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoRankTest {
    private lateinit var winningNumber: WinningNumber

    @BeforeEach
    fun beforeEach() {
        winningNumber = WinningNumber(numbers = Numbers(WINNING_NUMBERS), bonusBall = BonusBall(7))
    }

    @Test
    fun `로또 번호 6개가 일치하면 1등이다`() {
        LottoRank.getRank(
            lotto = Lotto(Numbers(WINNING_NUMBERS)),
            winningNumber = winningNumber,
        ) shouldBe LottoRank.FIRST
    }

    @Test
    fun `번호가 2개 이하로 일치하면 아무것도 해당하지 않는다`() {
        LottoRank.getRank(
            lotto = Lotto(Numbers(listOf(1, 2, 0, 0, 0, 0))),
            winningNumber = winningNumber,
        ) shouldBe LottoRank.NONE
    }

    @Test
    fun `번호 5개가 일치하고 보너스 번호가 일치하면 2등`() {
        LottoRank.getRank(
            lotto = Lotto(Numbers(listOf(1, 2, 3, 4, 5, BONUS_NUMBER))),
            winningNumber = winningNumber,
        ) shouldBe LottoRank.SECOND
    }

    @Test
    fun `번호 5개가 일치하지만 보너스 번호가 일치하지 않으면 3등`() {
        LottoRank.getRank(
            lotto = Lotto(Numbers(listOf(1, 2, 3, 4, 5, 0))),
            winningNumber = winningNumber,
        ) shouldBe LottoRank.THIRD
    }

    companion object {
        private const val BONUS_NUMBER = 7
        private val WINNING_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
    }
}
