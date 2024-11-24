package lotto.rank

import io.kotest.matchers.shouldBe
import lotto.Lotto
import lotto.ball.BonusBall
import lotto.number.Numbers
import lotto.statistics.WinningNumber
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

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

    @ParameterizedTest
    @MethodSource("noneLottos")
    fun `번호가 2개 이하로 일치하면 아무것도 해당하지 않는다`(lotto: Lotto) {
        LottoRank.getRank(
            lotto = lotto,
            winningNumber = winningNumber,
        ) shouldBe LottoRank.NONE
    }

    @ParameterizedTest
    @MethodSource("secondLottos")
    fun `번호 5개가 일치하고 보너스 번호가 일치하면 2등`(lotto: Lotto) {
        LottoRank.getRank(
            lotto = lotto,
            winningNumber = winningNumber,
        ) shouldBe LottoRank.SECOND
    }

    @ParameterizedTest
    @MethodSource("thirdLottos")
    fun `번호 5개가 일치하지만 보너스 번호가 일치하지 않으면 3등`(lotto: Lotto) {
        LottoRank.getRank(
            lotto = lotto,
            winningNumber = winningNumber,
        ) shouldBe LottoRank.THIRD
    }

    companion object {
        @JvmStatic
        private fun noneLottos() =
            listOf(
                Lotto(numbers = Numbers(listOf(1, 2, 0, 0, 0, 0))),
                Lotto(numbers = Numbers(listOf(3, 4, 0, 0, 0, 0))),
                Lotto(numbers = Numbers(listOf(5, 6, 0, 0, 0, 0))),
            )

        @JvmStatic
        private fun secondLottos() =
            listOf(
                Lotto(numbers = Numbers(listOf(1, 2, 3, 4, 5, BONUS_NUMBER))),
                Lotto(numbers = Numbers(listOf(2, 3, 4, 5, 6, BONUS_NUMBER))),
            )

        @JvmStatic
        private fun thirdLottos() =
            listOf(
                Lotto(numbers = Numbers(listOf(1, 2, 3, 4, 5, 0))),
                Lotto(numbers = Numbers(listOf(2, 3, 4, 5, 6, 0))),
            )

        private const val BONUS_NUMBER = 7
        private val WINNING_NUMBERS = listOf(1, 2, 3, 4, 5, 6)
    }
}
