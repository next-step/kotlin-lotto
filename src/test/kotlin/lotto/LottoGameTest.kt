package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoGameTest : FunSpec({
    context("로또 게임은") {
        val lottoList = listOf(
            Lotto(numbers = setOf(1, 20, 30, 27, 15, 36)),
            Lotto(numbers = setOf(10, 20, 30, 40, 25, 16)),
            Lotto(numbers = setOf(11, 12, 13, 14, 15, 16))
        )
        val winningNumbers = setOf(10, 15, 20, 25, 30, 35)
        val lottoGame = LottoGame(lottoList, winningNumbers)

        test("N개의 로또를 가진다.") {
            lottoGame.lottoList.size shouldBe 3
        }

        test("지난 주 당첨 번호를 가진다.") {
            lottoGame.winningNumbers shouldBe winningNumbers
        }
    }
})
