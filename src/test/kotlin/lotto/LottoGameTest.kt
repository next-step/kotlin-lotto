package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoGame
import lotto.domain.LottoGameResult
import lotto.domain.LottoReward

class LottoGameTest : FunSpec({
    context("로또 게임은") {
        val lottoList = listOf(
            Lotto(numbers = setOf(1, 15, 20, 27, 30, 36)),  // 4등
            Lotto(numbers = setOf(10, 16, 20, 25, 30, 40)), // 3등
            Lotto(numbers = setOf(11, 12, 13, 14, 15, 16)), // 미당첨
            Lotto(numbers = setOf(10, 15, 20, 25, 30, 40)), // 2등
            Lotto(numbers = setOf(10, 15, 20, 25, 30, 35))  // 1등
        )
        val winningNumbers = setOf(10, 15, 20, 25, 30, 35)
        val lottoGame = LottoGame(lottoList, winningNumbers)

        test("N개의 로또를 가진다.") {
            lottoGame.lottoList.size shouldBe 5
        }

        test("지난 주 당첨 번호를 가진다.") {
            lottoGame.winningNumbers shouldBe winningNumbers
        }

        test("3-6개 일치 로또의 개수를 계산할 수 있다.") {
            val expected = LottoGameResult(
                totalPrice = 5000,
                rewards = listOf(
                    LottoReward.FIRST,
                    LottoReward.SECOND,
                    LottoReward.THIRD,
                    LottoReward.FOURTH
                )
            )
            lottoGame.getResult() shouldBe expected
        }

        test("로또 게임은 총 수익률을 계산할 수 있다.") {
            lottoGame.getResult().calculatePerformance() shouldBe 400311
        }
    }
})
