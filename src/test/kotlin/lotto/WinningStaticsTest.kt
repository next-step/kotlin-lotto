package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domin.LottoNumberSet
import lotto.domin.LottoWinningAmount
import lotto.domin.WinningStatics
import lotto.dto.InputPaymentRequestDto
import lotto.dto.InputWinningLottoNumberDto

class WinningStaticsTest : FreeSpec({

    "result" - {

        "당첨 로또 개수와 수익률을 반환한다." {
            val lottoNumberSet = LottoNumberSet(listOf(1, 2, 3, 4, 5, 6))
            val lottoRecord = listOf(lottoNumberSet)
            val paymentDto = InputPaymentRequestDto.convertToOperand("14000")
            val winningLotto = InputWinningLottoNumberDto.convertOperand(listOf("1", "2", "3", "10", "11", "12"))
            val winningStat = WinningStatics(paymentDto, winningLotto, lottoRecord)

            val winningResult = winningStat.result()

            winningResult.winningLottoList[LottoWinningAmount.FOURTH] shouldBe 1

            winningResult.profitRatio shouldBe 0.35
        }
    }
})
