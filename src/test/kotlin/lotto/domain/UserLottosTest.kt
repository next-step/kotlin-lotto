package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class UserLottosTest : FreeSpec({
    "WinningLotto 와 BonusNumber를 받아 모든 Lotto의 matchCount, containsBonusNumber 결과를 반환한다" {
        val firstPrizeLottoNumbers = LottoNumbers(1, 2, 3, 4, 5, 6)
        val userLottos =
            UserLottos(
                listOf(
                    Lotto(firstPrizeLottoNumbers),
                    Lotto(1, 2, 3, 4, 5, 7),
                    Lotto(1, 2, 3, 4, 5, 45),
                    Lotto(1, 2, 3, 4, 44, 45),
                    Lotto(1, 2, 3, 43, 44, 45),
                    Lotto(1, 2, 42, 43, 44, 45),
                    Lotto(1, 41, 42, 43, 44, 45),
                    Lotto(40, 41, 42, 43, 44, 45),
                ),
            )
        val bonusNumber = LottoNumber(7)
        val winningLotto = WinningLotto(firstPrizeLottoNumbers, bonusNumber)

        val result = userLottos.match(winningLotto)

        result shouldBe
            listOf(
                MatchResult(6, false),
                MatchResult(5, true),
                MatchResult(5, false),
                MatchResult(4, false),
                MatchResult(3, false),
                MatchResult(2, false),
                MatchResult(1, false),
                MatchResult(0, false),
            )
    }

    "로또 구매 개수에 따라 구매 금액을 계산한다" - {
        listOf(
            listOf(Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 2, 3, 4, 5, 6)) to 2000,
            listOf(Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 2, 3, 4, 5, 6), Lotto(1, 2, 3, 4, 5, 6)) to 3000,
        ).forEach { lottosAndExpectedAmount ->
            val lottos = lottosAndExpectedAmount.first
            val expectedAmount = lottosAndExpectedAmount.second

            "입력값: 구매 개수 = ${lottos.size}, 예상 구매 금액 = $expectedAmount" {
                val userLottos = UserLottos(lottos)
                userLottos.calculatePurchaseAmount() shouldBe expectedAmount
            }
        }
    }
})
