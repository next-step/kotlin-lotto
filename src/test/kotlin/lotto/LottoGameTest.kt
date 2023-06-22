package lotto

import io.kotest.matchers.shouldBe
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
}
