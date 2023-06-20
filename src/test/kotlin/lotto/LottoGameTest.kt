package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.test.FixedPurchaseCommand
import lotto.test.lottoNumbersOf
import lotto.view.InputView
import lotto.view.OutputView
import lotto.vo.LottoNumber
import lotto.vo.Money

class LottoGameTest : FreeSpec({
    "로또 게임은 입출력을 수행한다." - {
        forAll(
            row(
                Money(3400),
                FixedPurchaseCommand(
                    listOf(
                        Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(3, 42, 44, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(7, 8, 9, 10, 11, 12)),
                    )
                ),
                lottoNumbersOf(1, 2, 3, 4, 5, 6),
                3,
                Lottos(
                    listOf(
                        Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(3, 42, 44, 4, 5, 6)),
                        Lotto.from(lottoNumbersOf(7, 8, 9, 10, 11, 12)),
                    )
                ), Money(3000),
                listOf(WinningPrize.MATCH_3 to 0, WinningPrize.MATCH_4 to 1, WinningPrize.MATCH_5 to 0, WinningPrize.MATCH_6 to 1)
            ),

            )
        { givenAmountOfMoney, givenLottoCommand, givenWinningNumbers, expectedLottoCount, expectedLottos, expectedPaidPrice, expectedPrize ->
            val inputView = FakeInputView(givenAmountOfMoney, givenWinningNumbers)
            val outputView = FakeOutputView()
            val lottoGame = LottoGame(inputView, outputView)

            lottoGame.run(givenLottoCommand)

            // 1. 금액을 입력받은 후 구매한 로또의 정보를 출력한다.
            outputView.givenLottos.size shouldBe expectedLottoCount

            // 2. 당첨 번호를 입력 받은 후 구매한 로또의 당첨 정보를 출력한다.
            outputView.givenLottos shouldBe expectedLottos
            outputView.givenPaidPriceOfResult.paidPrice shouldBe expectedPaidPrice
            outputView.givenPaidPriceOfResult.prizes shouldBe expectedPrize
        }

    }
}) {
    private class FakeInputView(
        private val inputMoney: Money,
        private val inputWinningNumbers: List<LottoNumber>,
    ) : InputView {
        override fun receiveMoney(): Money {
            return inputMoney
        }

        override fun receiveWinningNumbers(): List<LottoNumber> {
            return listOf(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::from)
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
