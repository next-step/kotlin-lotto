package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat

class LottoGameTest : StringSpec({

    "로또 게임은, 금액을 받아서 천원당 하나의 로또를 가지고 있는다" {
        // given
        val lottoGame = LottoGame(14000)
        // when
        val lottos = lottoGame.getLottos()
        // then
        lottos.size shouldBe 14
    }

    "로또 게임은, 지난주 당첨 번호받아 로또를 평가하면, 로또는 등급을 갖는다" {
        // given
        val lottoGame = LottoGame(14000)
        // when
        lottoGame.draw(listOf(1, 2, 3, 4, 5, 6))
        // then
        lottoGame.getLottos().forEach {
            assertThat(it.grade).isNotNull()
        }
    }

    "로또 게임은, 수익률을 계산한다" {
        // given
        val lottoGame = LottoGame(2000, StaticLottoNumberGenerator(listOf(1, 2, 3, 11, 12, 13)))
        lottoGame.draw(listOf(1, 2, 3, 4, 5, 6))
        // when
        val winningRate = lottoGame.winningRate()
        // then
        winningRate shouldBe 5
    }
})
