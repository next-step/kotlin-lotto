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
                    LottoNumber.valueOf(1),
                    LottoNumber.valueOf(2),
                    LottoNumber.valueOf(3),
                    LottoNumber.valueOf(4),
                    LottoNumber.valueOf(5),
                    LottoNumber.valueOf(6)
                )
            ),
            LottoNumber.valueOf(10)
        )
        // then
        drawResult.forEach {
            it shouldBeIn LottoGrade.values().toList()
        }
    }

    "로또 게임은, 수동으로 번호를 입력 받아서 로또를 생성할 수 있다." {
        // given
        val directLottoNumber = listOf(
            LottoNumbers(
                listOf(
                    LottoNumber.valueOf(1),
                    LottoNumber.valueOf(2),
                    LottoNumber.valueOf(3),
                    LottoNumber.valueOf(4),
                    LottoNumber.valueOf(5),
                    LottoNumber.valueOf(6)
                )
            )
        )
        // when
        val lottoGame = LottoGame(PurchaseAmount(14000), directLottoNumber)
        // then
        lottoGame.getLottos().size shouldBe 14
        lottoGame.getDirectLottoCount() shouldBe 1
    }
})
