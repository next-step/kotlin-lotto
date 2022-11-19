package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoGameTest : StringSpec({

    "로또 게임은, 금액을 받아서 천원당 하나의 로또를 가지고 있는다" {
        // given
        val lottoGame = LottoGame(14000)
        // when
        val lottos = lottoGame.lottos
        // then
        lottos.size shouldBe 14
    }

    "로또 게임은, 지난주 당첨 번호를 저장할 수 있다" {
        // given
        val lottoGame = LottoGame(14000)
        // when
        lottoGame.winningNumber = listOf(1, 2, 3, 4, 5, 6)
        // then
        lottoGame.winningNumber shouldBe listOf(1, 2, 3, 4, 5, 6)
    }

    "로또 게임은, 수익률을 계산한다" {
        // given
        val lottoGame = LottoGame(2000, StaticLottoNumberGenerator(listOf(1, 2, 3, 11, 12, 13)))
        lottoGame.winningNumber = listOf(1, 2, 3, 4, 5, 6)
        // when
        val winningRate = lottoGame.winningRate()
        // then
        winningRate shouldBe 5
    }
})
