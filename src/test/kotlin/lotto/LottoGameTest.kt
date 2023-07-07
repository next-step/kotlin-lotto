package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test

class LottoGameTest {
    private var winningNumbers: WinningNumbers = WinningNumbers(LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.from(7))

    @Test
    fun `로또 게임은 로또 번호들과 당첨 번호를 받아 결과를 생성한다`() {
        val numbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 5, 8),
            listOf(1, 2, 3, 4, 7, 8),
            listOf(1, 2, 3, 7, 8, 9),
            listOf(1, 2, 7, 8, 9, 10),
            listOf(1, 7, 8, 9, 10, 11),
            listOf(7, 8, 9, 10, 11, 12),
        )

        val lottoNumbers = numbers.map { LottoNumbers.from(it) }
        val lottoGame = LottoGame(winningNumbers)
        val result = lottoGame.calculate(lottoNumbers)

        result.countByRank(Rank.FIRST) shouldBe 1
        result.countByRank(Rank.SECOND) shouldBe 1
        result.countByRank(Rank.THIRD) shouldBe 1
        result.countByRank(Rank.FIRST) shouldBe 1
        result.countByRank(Rank.FIFTH) shouldBe 1
        result.countByRank(Rank.LOSE) shouldBe 3
    }

    @Test
    fun `수동 게임 수에 따라 자동 게임 수가 계산된다`() {
        val purchaseAmount = 14000
        val manualGameCount = 3

        LottoGame.getAutoGameCount(purchaseAmount, manualGameCount) shouldBe 11
    }

    @Test
    fun `수동 구매 금액이 총 구입 금액을 초과하면 자동 게임 수 계산 시 예외가 발생한다`() {
        val purchaseAmount = 14000
        val manualGameCount = 15

        shouldThrow<IllegalArgumentException> { LottoGame.getAutoGameCount(purchaseAmount, manualGameCount) }
            .shouldHaveMessage("수동으로 구매할 로또의 금액은 전체 구입 금액 초과할 수 없습니다. purchaseAmount:14000, manualGameCost:15000")
    }
}
