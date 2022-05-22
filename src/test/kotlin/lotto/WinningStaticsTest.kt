package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class WinningStaticsTest : FreeSpec({

    "run" - {

        "당첨 로또 개수와 수익률을 반환한다." {
            val lottoNumberSet = LottoNumberSet(listOf(1, 2, 3, 4, 5, 6))
            val lottoRecord = listOf(lottoNumberSet)
            val paymentDto = InputPaymentRequestDto.convertInt("14000")
            val winningLotto = InputWinningLottoNumberDto.convertInt(listOf("1", "2", "3", "10", "11", "12"))
            val winningStat = WinningStatics(paymentDto, winningLotto, lottoRecord)

            val winningResult = winningStat.run()

            winningResult.winningLottoList[LottoWinningAmount.FOURTH] shouldBe 1

            winningResult.profitRatio shouldBe 0.35
        }
    }
})
