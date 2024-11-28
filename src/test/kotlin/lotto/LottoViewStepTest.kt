package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoViewStepTest {
    @Test
    fun `구매요금을 입력받는다`() {
        val inputAmountStep = InputAmountStep(inputProvider = { "1000" })

        val actual = inputAmountStep.apply(lottoMachine = LottoMachine())

        assertThat(actual).isEqualTo(LottoResult.SuccessStep.InputAmountStep(Amount(1_000)))
    }

    @Test
    fun `수동번호를 입력받는다`() {
        val inputs = ArrayDeque(listOf("1", "1,2,3,4,5,6"))
        val inputManualStep = InputManualBuyStep(inputProvider = { inputs.removeFirst() })

        val actual = inputManualStep.apply(lottoMachine = LottoMachine())

        val expected = LottoResult.SuccessStep.InputManualStep(Lottos(listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)))))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `지난주 로또번호를 입력 받는다`() {
        val inputs = ArrayDeque(listOf("1,2,3,4,5,6"))
        val inputLastWeekStep = InputLastWeekNumbersStep(inputProvider = { inputs.removeFirst() })

        val actual = inputLastWeekStep.apply(lottoMachine = LottoMachine())

        val expected = LottoResult.SuccessStep.InputLastWeekNumbersStep(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `보너스 번호를 입력 받는다`() {
        val inputBonusStep = InputBonusNumberStep(inputProvider = { "1" })

        val actual = inputBonusStep.apply(lottoMachine = LottoMachine())

        assertThat(actual).isEqualTo(LottoResult.SuccessStep.InputBonusNumberStep(LottoNumber(1)))
    }
}