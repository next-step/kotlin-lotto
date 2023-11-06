package lotto.controller

import lotto.controller.LottoController.Companion.LOTTO_NUMBER_COUNT
import lotto.model.LottoInfo
import lotto.model.getTotalPrizeMoney
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.math.round

class LottoControllerTest {

    @ParameterizedTest
    @ValueSource(strings = ["140", "-100", "abcde"])
    fun `로또 구매 금액 검증`(inputPurchaseAmount: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoController(inputPurchaseAmount).getValidatePurchaseAmount()
        }
    }

    @Test
    fun `생성한 로또 번호 검증`() {
        val lottoController = LottoController("14000")
        val generatedNumbers = lottoController.getRandomGeneratedNumbers()
        assertThat(generatedNumbers.toSet().size == LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `구매한 금액만큼의 로또 개수`() {
        assertThat(LottoController("14000").getPaidLottoCount()).isEqualTo(14)
        assertThat(LottoController("1000").getPaidLottoCount()).isEqualTo(1)
    }

    @ParameterizedTest
    @MethodSource
    fun `일치한 번호 개수`(generatedLottoInfo: LottoInfo, latestWinLottoInfo: LottoInfo, expectedCorrections: Int) {
        assertThat(LottoController("1000").countCorrectNumberCount(generatedLottoInfo, latestWinLottoInfo)).isSameAs(
            expectedCorrections
        )
    }

    @Test
    fun `일치하는 번호 개수별 분류`() {
        val latestWinLottoInfo = LottoInfo(listOf(1, 2, 3, 4, 5, 6))
        val generatedInfos = listOf(
            LottoInfo(listOf(1, 20, 30, 40, 41, 42)), // 1개 일치
            LottoInfo(listOf(1, 2, 3, 4, 5, 16)), // 5개 일치
            LottoInfo(listOf(1, 2, 3, 4, 5, 27)), // 5개 일치
            LottoInfo(listOf(1, 2, 3, 4, 5, 6)), // 6개 일치
        )

        val correctnessInfo = LottoController("1000").classifyCorrectness(
            generatedInfos,
            latestWinLottoInfo,
            minCorrectnessCountForShow = 3
        )

        (0..4).forEach {
            assertThat(
                correctnessInfo.find { info -> info.correctnessNumCount == it }?.correctLottoInfoCount ?: 0
            ).isEqualTo(0)
        }
        assertThat(
            correctnessInfo.find { info -> info.correctnessNumCount == 5 }?.correctLottoInfoCount ?: 0
        ).isEqualTo(2)
        assertThat(
            correctnessInfo.find { info -> info.correctnessNumCount == 6 }?.correctLottoInfoCount ?: 0
        ).isEqualTo(1)
    }

    @Test
    fun `수익률 확인`() {
        val latestWinLottoInfo = LottoInfo(listOf(1, 2, 3, 4, 5, 6))
        val generatedInfos = listOf(
            LottoInfo(listOf(1, 20, 30, 40, 41, 42)), // 1개 일치
            LottoInfo(listOf(1, 2, 3, 4, 5, 16)), // 5개 일치
            LottoInfo(listOf(1, 2, 3, 4, 5, 27)), // 5개 일치
            LottoInfo(listOf(1, 2, 3, 4, 5, 6)), // 6개 일치
        )

        val paidMoney = 1000

        val lottoController = LottoController(paidMoney.toString())

        val correctnessInfo = lottoController.classifyCorrectness(
            generatedInfos,
            latestWinLottoInfo,
            minCorrectnessCountForShow = 3
        )

        val prizeMoneyToTake = correctnessInfo.getTotalPrizeMoney()
        assertThat(lottoController.calculateEarningRate(prizeMoneyToTake)).isEqualTo(
            round(2003000000.toDouble() / 1000.toDouble() * 100) / 100
        )
    }

    companion object {
        @JvmStatic
        fun `일치한 번호 개수`() = listOf(
            Arguments.of(LottoInfo(listOf(1, 2, 3, 4, 5, 6)), LottoInfo(listOf(1, 2, 3, 4, 5, 6)), 6),
            Arguments.of(LottoInfo(listOf(1, 2, 3, 4, 5, 6)), LottoInfo(listOf(1, 2, 3, 4, 5, 10)), 5),
            Arguments.of(LottoInfo(listOf(1, 2, 3, 4, 5, 6)), LottoInfo(listOf(1, 2, 3, 4, 50, 60)), 4),
            Arguments.of(LottoInfo(listOf(1, 2, 3, 4, 5, 6)), LottoInfo(listOf(10, 20, 30, 40, 50, 60)), 0),
        )
    }
}
