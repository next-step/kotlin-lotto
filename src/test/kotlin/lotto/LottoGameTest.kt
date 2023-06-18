package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.view.InputView
import lotto.view.OutputView
import lotto.vo.Money

class LottoGameTest : FreeSpec({
    "로또 게임은 입출력을 수행한다." - {
        forAll(
            row(15400, 15, 15000),
            row(19999, 19, 19000),
            row(300, 0, 0),
        ) { givenAmountOfMoney, expectedLottoCount, expectedPaidPrice ->
            val inputView = FakeInputView(Money(givenAmountOfMoney))
            val outputView = FakeOutputView()
            val lottoGame = LottoGame(inputView, outputView)

            lottoGame.run()

            // 1. 금액을 입력받은 후 구매한 로또의 정보를 출력한다.
            outputView.givenLottos.size shouldBe expectedLottoCount

            // 2. 당첨 번호를 입력 받은 후 구매한 로또의 당첨 정보를 출력한다.
            outputView.givenPaidPriceOfResult shouldNotBe null
            outputView.givenPaidPriceOfResult.paidPrice shouldBe Money(expectedPaidPrice)
        }

    }
}) {
    private class FakeInputView(
        private val inputMoney: Money,
    ) : InputView {
        override fun receiveMoney(): Money {
            return inputMoney
        }

        override fun receiveWinningNumbers(): List<Int> {
            return listOf(1, 2, 3, 4, 5, 6)
        }
    }

    private class FakeOutputView : OutputView {
        lateinit var givenLottos: Lottos
        lateinit var givenPaidPriceOfResult: GameResult

        override fun showPurchased(lottos: Lottos) {
            givenLottos = lottos
        }

        override fun show(result: GameResult) {
            givenPaidPriceOfResult = result
        }
    }
}


