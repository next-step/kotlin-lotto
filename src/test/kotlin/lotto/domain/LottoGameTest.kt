package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameTest : FunSpec({
    context("로또 게임은") {
        val lottoList = listOf(
            LottoNumbers(setOf(1, 15, 20, 27, 30, 36)),  // 4등
            LottoNumbers(setOf(10, 16, 20, 25, 30, 40)), // 3등
            LottoNumbers(setOf(11, 12, 13, 14, 15, 16)), // 미당첨
            LottoNumbers(setOf(10, 15, 20, 25, 30, 40)), // 3등
            LottoNumbers(setOf(10, 15, 20, 25, 30, 13)), // 2등
            LottoNumbers(setOf(10, 15, 20, 25, 30, 35))  // 1등
        )
        val winningNumbers = WinningNumbers(LottoNumbers(setOf(10, 15, 20, 25, 30, 35)), BonusNumber(13))
        val lottoGame = LottoGame(lottoList)

        test("N개의 로또를 가진다.") {
            lottoGame.lottoList.size shouldBe 6
        }

        test("3-6개 일치 로또의 개수를 계산할 수 있다.") {
            val expected = LottoGameResult(
                totalPrice = 6000,
                rewards = listOf(
                    LottoReward.FIRST,
                    LottoReward.SECOND,
                    LottoReward.THIRD,
                    LottoReward.FOURTH,
                    LottoReward.FIFTH
                )
            )
            lottoGame.getResult(winningNumbers) shouldBe expected
        }

        test("로또 게임은 총 수익률을 계산할 수 있다.") {
            lottoGame.getResult(winningNumbers).calculatePerformance() shouldBe 338592.5
        }
    }
})
