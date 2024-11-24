package lotto

import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe
import lotto.ball.BonusBall
import lotto.number.Numbers
import lotto.rank.LottoRank
import lotto.statistics.WinningNumber
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    private lateinit var winningNumber: WinningNumber

    @BeforeEach
    fun beforeEach() {
        winningNumber = WinningNumber(numbers = Numbers(WINNING_NUMBERS), bonusBall = BonusBall(7))
    }

    @Test
    fun `번호가 모두 일치하면 1등 로또이다`() {
        val lotto = Lotto(numbers = Numbers(WINNING_NUMBERS))

        lotto.numbers.numbers shouldBe WINNING_NUMBERS
        lotto.getRank(winningNumber) shouldBe LottoRank.FIRST
    }

    @ParameterizedTest
    @MethodSource("noneLottos")
    fun `번호가 2개 이하로 일치하면 당첨되지 않은 로또이다`(lotto: Lotto) {
        lotto.numbers.numbers
            .filter { it in WINNING_NUMBERS }
            .size shouldBeLessThanOrEqual 2
        lotto.getRank(winningNumber) shouldBe LottoRank.NONE
    }

    @ParameterizedTest
    @MethodSource("secondLottos")
    fun `번호가 5개 일치하고 보너스 번호도 일치하면 2등 로또이다`(lotto: Lotto) {
        lotto.numbers.numbers
            .filter { it in WINNING_NUMBERS }
            .size shouldBeLessThanOrEqual 5
        lotto.numbers.numbers.contains(BONUS_NUMBER) shouldBe true
        lotto.getRank(winningNumber) shouldBe LottoRank.SECOND
    }

    @ParameterizedTest
    @MethodSource("thirdLottos")
    fun `번호가 5개 일치하고 보너스 번호도 일치하지 않으면 3등 로또이다`(lotto: Lotto) {
        lotto.numbers.numbers
            .filter { it in WINNING_NUMBERS }
            .size shouldBeLessThanOrEqual 5
        lotto.numbers.numbers.contains(BONUS_NUMBER) shouldBe false
        lotto.getRank(winningNumber) shouldBe LottoRank.THIRD
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
