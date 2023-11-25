package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class LottoGameTest : FunSpec({

    test("로또 게임에선 로또를 구입하고, 결과를 생성할 수 있다.") {
        // given
        val purchaseMoney = 1_000L
        val winningLottoNumbers = LottoNumbers.of(setOf(1, 2, 3, 4, 5, 6))

        // when
        val lottoGame = LottoGame(purchaseMoney)

        // then
        lottoGame.purchaseMoney shouldBe purchaseMoney
        lottoGame.lottoTickets shouldNotBe null
        lottoGame.generateLottoGameResult(winningLottoNumbers) shouldNotBe null
    }
})
