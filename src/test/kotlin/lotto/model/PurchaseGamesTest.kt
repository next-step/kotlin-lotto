package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PurchaseGamesTest : StringSpec({

    "자동으로 구매한 수량만큼 로또게임이 만들어진다" {
        val actual = LottoPurchaseInfo(2, listOf())

        actual.totalPurchaseCount shouldBe 2
        actual.manualIssuedGames.size shouldBe 0
    }

    "수동으로 구매한 만큼 로또 게임이 만들어진다" {
        val games = listOf(
            Game(LottoNumbers(1, 2, 3, 4, 5, 6)),
            Game(LottoNumbers(1, 2, 3, 4, 5, 6))
        )
        val actual = LottoPurchaseInfo(2, games)

        actual.totalPurchaseCount shouldBe 2
        actual.manualIssuedGames.size shouldBe 2
    }

    "총 구매 수량보다 수동 구매 수량이 많게 입력되면 IllegalArgumentException throw" {
        val games = listOf(
            Game(LottoNumbers(1, 2, 3, 4, 5, 6)),
            Game(LottoNumbers(1, 2, 3, 4, 5, 6))
        )
        shouldThrow<IllegalArgumentException> {
            LottoPurchaseInfo(1, games)
        }
    }

    "발권이 불가능한 문자열이 입력되면 IllegalArgumentException throw 해야한다" {
        shouldThrow<IllegalArgumentException> {
            println("숫자가 5개라서 실패")
            LottoPurchaseInfo(3, listOf(Game(LottoNumbers(1, 2, 3, 4, 5))))
        }
        shouldThrow<IllegalArgumentException> {
            println("숫자가 7개라서 실패")
            LottoPurchaseInfo(3, listOf(Game(LottoNumbers(1, 2, 3, 4, 5, 6, 7))))
        }
    }

    "구매할 로또 Game 하나의 가격은 1000 이다" {
        LottoPurchaseInfo.priceOfGame() shouldBe 1000
    }
})
