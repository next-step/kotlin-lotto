package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class BudgetTest {

    @Test
    fun `예산을 생성할 수 있다`() {
        val budget = Budget.valueOf(1000)

        assertThat(budget).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000, 3000])
    fun `예산을 입력하면 구매 가능한 로또 갯수를 출력한다`(givenValue: Int) {
        // given
        val budget = Budget.valueOf(givenValue)
        val lottoPrice = 1000
        val expected = givenValue / lottoPrice

        // then
        assertThat(budget.getLottoCount()).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [100, 500, 900])
    fun `예산에 최소 로또 금액을 입력하지 않으면 예외를 던진다`(givenValue: Int) {
        assertThrows<IllegalArgumentException> { Budget.valueOf(givenValue) }
    }

    @Test
    fun `에산으로 수동구매 갯수 가능여부를 리턴한다`() {
        val givenBudget = Budget.valueOf(2000)
        val manualCount = 1

        assertThat(givenBudget.validateManualCount(manualCount)).isTrue
    }

    @Test
    fun `남은 갯수를 리턴한다`() {
        val givenBudget = Budget.valueOf(4000)
        val manualCount = 2

        assertThat(givenBudget.getRemainCount(manualCount)).isEqualTo(2)
    }
}
