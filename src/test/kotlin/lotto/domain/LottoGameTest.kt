package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class LottoGameTest : FunSpec({

    test("로또 게임에선 로또를 구입하고, 결과를 생성할 수 있다.") {
        // given
        val purchaseMoney = 1_000L
        val winningLottoNumbers = setOf(1, 2, 3, 4, 5, 6)
        val lottoGame = LottoGame()

        // when
        lottoGame.purchaseLotto(purchaseMoney = purchaseMoney)

        // then
        lottoGame.purchaseMoney shouldBe purchaseMoney
        lottoGame.lottoTickets shouldNotBe null
        lottoGame.generateLottoGameResult(winningLottoNumbers) shouldNotBe null
    }

    test("구매하지 않고 구입금액을 조회 할 경우 IllegalStateException throw") {
        shouldThrow<IllegalStateException> {
            LottoGame().purchaseMoney
        }
    }

    test("구매하지 않고 로또를 조회 할 경우 IllegalStateException throw") {
        shouldThrow<IllegalStateException> {
            LottoGame().lottoTickets
        }
    }

    test("구매하지 않고 로또결과를 생성 할 경우 IllegalStateException throw") {
        shouldThrow<IllegalStateException> {
            val winningLottoNumbers = setOf(1, 2, 3, 4, 5, 6)
            LottoGame().generateLottoGameResult(winningLottoNumbers)
        }
    }
})
