package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.prize.Prize
import lotto.test.lottoNumbersOf
import lotto.view.InputView
import lotto.view.OutputView
import lotto.vo.LottoNumber
import lotto.vo.Money
import lotto.vo.WinningNumbers

class LottoGameTest : FreeSpec({
    "로또 게임은 입출력을 수행한다." - {
        forAll(
            row(
                Money(2400),
                listOf(
                    Lotto.from(lottoNumbersOf(1, 2, 3, 4, 5, 6))
                ),
                listOf(
                    Lotto.from(lottoNumbersOf(7, 8, 9, 10, 11, 12))
                ),
                WinningNumbers(lottoNumbersOf(1, 2, 3, 4, 5, 6), LottoNumber.from(7)),
                Money(2000),
                listOf(Prize.MATCH_3 to 0, Prize.MATCH_4 to 0, Prize.MATCH_5 to 0, Prize.MATCH_5_BONUS to 0, Prize.MATCH_6 to 1)
            ),

            )
        { givenAmountOfMoney, givenManualLottos, givenAutoGeneratedLottos, givenWinningNumbers, expectedPaidPrice, expectedPrize ->
            val givenPurchaseCommand = ManualPurchaseCommand(givenManualLottos)
            val inputView = FakeInputView(givenAmountOfMoney, givenWinningNumbers, givenPurchaseCommand)
            val outputView = FakeOutputView()
            val lottoShop = FakeLottoShop(givenAutoGeneratedLottos)

            val lottoGame = LottoGame(inputView, outputView, lottoShop)

            lottoGame.run()

            val expectedLottos = Lottos(
                manualLottos = givenManualLottos,
                autoGeneratedLottos = givenAutoGeneratedLottos
            )

            // 1. 금액을 입력받은 후 구매한 로또의 정보를 출력한다.
            outputView.givenLottos shouldBe expectedLottos

            // 2. 당첨 번호를 입력 받은 후 구매한 로또의 당첨 정보를 출력한다.
            outputView.givenPaidPriceOfResult.paidPrice shouldBe expectedPaidPrice
            outputView.givenPaidPriceOfResult.prizes shouldBe expectedPrize
        }

    }
}) {
    private class FakeInputView(
        private val inputMoney: Money,
        private val inputWinningNumbers: WinningNumbers,
        private val inputPurchaseCommand: ManualPurchaseCommand,
    ) : InputView {
        override fun receiveMoney(): Money {
            return inputMoney
        }

        override fun receiveWinningNumbers(): WinningNumbers {
            return inputWinningNumbers
        }

        override fun receivePurchaseCommand(): ManualPurchaseCommand {
            return inputPurchaseCommand
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

    private class FakeLottoShop(
        private val givenAutoGeneratedLottos: List<Lotto>,
    ) : LottoShop {
        override fun sell(cash: Money, manualPurchaseCommand: ManualPurchaseCommand): Lottos {
            return Lottos(
                manualLottos = manualPurchaseCommand.lottos,
                autoGeneratedLottos = givenAutoGeneratedLottos
            )
        }
    }
}
