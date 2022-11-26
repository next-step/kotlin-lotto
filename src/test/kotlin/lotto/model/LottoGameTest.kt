package lotto.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeIn
import io.kotest.matchers.shouldBe

class LottoGameTest : StringSpec({

    "로또 게임은, 금액을 받아서 천원당 하나의 로또를 가지고 있는다" {
        // given
        val lottoGame = LottoGame(14000)
        // when
        val lottos = lottoGame.getLottos()
        // then
        lottos.size shouldBe 14
    }

    "로또 게임은, 지난주 당첨 번호받아 로또를 평가하면, 등급을 반환한다" {
        // given
        val lottoGame = LottoGame(14000)
        // when
        val drawResult = lottoGame.draw(
            LottoNumbers(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6)
                )
            ),
            LottoNumber(10)
        )
        // then
        drawResult.forEach {
            it shouldBeIn LottoGrade.values().toList()
        }
    }
})
