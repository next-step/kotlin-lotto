package lotto

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import lotto.domin.LottoNumberSet
import lotto.domin.LottoWinningAmount
import lotto.domin.WinningStatics
import lotto.dto.InputLottoMachineRequestDto
import lotto.dto.InputLottoNumberDto

class WinningStaticsTest : FreeSpec({

    "result" - {

        "당첨된 로또가 없는 경우 결과를 반환한다." {
            val lottoNumberSet = LottoNumberSet(listOf(13, 14, 15, 16, 17, 18))
            val lottoRecord = listOf(lottoNumberSet)
            val paymentDto = InputLottoMachineRequestDto.of("14000", "2")
            val winningLotto = InputLottoNumberDto.of(listOf("1", "2", "3", "10", "11", "12"), "13")
            val winningStat = WinningStatics(paymentDto, winningLotto, lottoRecord)

            val winningResult = winningStat.result()

            LottoWinningAmount.values().forEach { it ->
                winningResult.winningLottoList[it] shouldBe 0
            }
            winningResult.profitRatio shouldBe 0
        }

        "당첨 로또가 3개인 경우 5등입니다." {
            val lottoNumberSet = LottoNumberSet(listOf(1, 2, 3, 4, 5, 6))
            val lottoRecord = listOf(lottoNumberSet)
            val paymentDto = InputLottoMachineRequestDto.of("14000", "2")
            val winningLotto = InputLottoNumberDto.of(listOf("1", "2", "3", "10", "11", "12"), "13")
            val winningStat = WinningStatics(paymentDto, winningLotto, lottoRecord)

            val winningResult = winningStat.result()

            winningResult.winningLottoList[LottoWinningAmount.FIFTH] shouldBe 1
            winningResult.profitRatio shouldBe 0.35
        }

        "당첨 로또가 4개인 경우 4등입니다." {
            val lottoNumberSet = LottoNumberSet(listOf(1, 2, 3, 10, 5, 6))
            val lottoRecord = listOf(lottoNumberSet)
            val paymentDto = InputLottoMachineRequestDto.of("14000", "2")
            val winningLotto = InputLottoNumberDto.of(listOf("1", "2", "3", "10", "11", "12"), "13")
            val winningStat = WinningStatics(paymentDto, winningLotto, lottoRecord)

            val winningResult = winningStat.result()

            winningResult.winningLottoList[LottoWinningAmount.FOURTH] shouldBe 1
            winningResult.profitRatio shouldBe 3.57
        }

        "당첨 로또가 보너스는 일치하지 않는 5개인 경우 3등입니다." {
            val lottoNumberSet = LottoNumberSet(listOf(1, 2, 3, 10, 11, 6))
            val lottoRecord = listOf(lottoNumberSet)
            val paymentDto = InputLottoMachineRequestDto.of("14000", "2")
            val winningLotto = InputLottoNumberDto.of(listOf("1", "2", "3", "10", "11", "12"), "20")
            val winningStat = WinningStatics(paymentDto, winningLotto, lottoRecord)

            val winningResult = winningStat.result()

            winningResult.winningLottoList[LottoWinningAmount.THIRD] shouldBe 1
            winningResult.profitRatio shouldBe 107.14
        }

        "당첨 로또가 보너스가 일치하는 5개인 경우 2등입니다." {
            val lottoNumberSet = LottoNumberSet(listOf(1, 2, 3, 10, 11, 6))
            val lottoRecord = listOf(lottoNumberSet)
            val paymentDto = InputLottoMachineRequestDto.of("14000", "2")
            val winningLotto = InputLottoNumberDto.of(listOf("1", "2", "3", "10", "11", "12"), "6")
            val winningStat = WinningStatics(paymentDto, winningLotto, lottoRecord)

            val winningResult = winningStat.result()

            winningResult.winningLottoList[LottoWinningAmount.SECOND] shouldBe 1
            winningResult.profitRatio shouldBe 2142.85
        }

        "당첨 로또가 6개인 경우 1등입니다." {
            val lottoNumberSet = LottoNumberSet(listOf(1, 2, 3, 10, 11, 12))
            val lottoRecord = listOf(lottoNumberSet)
            val paymentDto = InputLottoMachineRequestDto.of("14000", "2")
            val winningLotto = InputLottoNumberDto.of(listOf("1", "2", "3", "10", "11", "12"), "13")
            val winningStat = WinningStatics(paymentDto, winningLotto, lottoRecord)

            val winningResult = winningStat.result()

            winningResult.winningLottoList[LottoWinningAmount.FIRST] shouldBe 1
            winningResult.profitRatio shouldBe 142857.14
        }
    }
})
