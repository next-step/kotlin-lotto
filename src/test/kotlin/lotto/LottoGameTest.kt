package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoGameTest {
    private var winningNumbers: WinningNumbers = WinningNumbers(LottoNumbers.from(listOf(1, 2, 3, 4, 5, 6)), LottoNumber.from(7))

    @Test
    fun `count를 입력 받은만큼 랜덤 번호를 생성한다`() {
        val lottoGame = LottoGame.from(10, winningNumbers)

        lottoGame.lottoNumbers.size shouldBe 10
    }

    @Test
    fun `로또 게임은 로또 번호들과 당첨 번호를 받아 결과를 생성한다`() {
        val numbers = listOf(
            listOf(1, 2, 3, 4, 5, 6),
            listOf(1, 2, 3, 4, 5, 7),
            listOf(1, 2, 3, 4, 7, 8),
            listOf(1, 2, 3, 7, 8, 9),
            listOf(1, 2, 7, 8, 9, 10),
            listOf(1, 7, 8, 9, 10, 11),
            listOf(7, 8, 9, 10, 11, 12),
        )

        val lottoNumbers = numbers.map { LottoNumbers.from(it) }
        val lottoGame = LottoGame(lottoNumbers, winningNumbers)
        val result = lottoGame.result

        result.countByRank(Rank.FIRST) shouldBe 1
        result.countByRank(Rank.SECOND) shouldBe 1
        result.countByRank(Rank.THIRD) shouldBe 1
        result.countByRank(Rank.FIRST) shouldBe 1
        result.countByRank(Rank.LOSE) shouldBe 3
    }
}
