package domain.winning

import domain.money.Money
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class IncomeExpenditureRatioTest {
    @Test
    fun `지출대비수익률은 실수값으로 생성된다`() {
        assertDoesNotThrow { IncomeExpenditureRatio(1.0) }
    }

    @Test
    fun `지출대비수익률은 지출액과 수익으로 생성된다`() {
        assertDoesNotThrow { IncomeExpenditureRatio.calculatedBy(income = Money(1000), expenditure = Money(1000)) }
    }

    @Test
    fun `지출대비수익률은 객체가 달라도, 실수값이 같으면 동일하다`() {
        assertThat(IncomeExpenditureRatio(1.0)).isEqualTo(IncomeExpenditureRatio(1.0))
    }

    @ParameterizedTest
    @CsvSource(
        "500, 1000",
        "5000, 5000",
        "9898, 1203"
    )
    fun `지출대비수익률은 수익 나누기 지출 값과 동일하다`(income: Long, expenditure: Long) {
        val actualRatio = IncomeExpenditureRatio.calculatedBy(income = Money(income), expenditure = Money(expenditure))
        val expectedRatio = IncomeExpenditureRatio(income.toDouble() / expenditure.toDouble())
        assertThat(actualRatio).isEqualTo(expectedRatio)
    }

    @Test
    fun `지출이 0원일 수 없다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { IncomeExpenditureRatio.calculatedBy(income = Money(1000), expenditure = Money.ZERO) }
    }
}
