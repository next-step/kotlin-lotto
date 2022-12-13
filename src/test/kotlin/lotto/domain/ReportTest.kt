package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ReportTest {

    @Test
    fun `기본으로 생성된 리포트는 모두 0이다`() {
        val emptyReport = Report()

        assertThat(emptyReport).isEqualTo(Report(Ranks()))
        assertThat(emptyReport.firstCount).isEqualTo(0)
        assertThat(emptyReport.secondCount).isEqualTo(0)
        assertThat(emptyReport.thirdCount).isEqualTo(0)
        assertThat(emptyReport.fourthCount).isEqualTo(0)
        assertThat(emptyReport.fifthCount).isEqualTo(0)
        assertThat(emptyReport.getRateOfReturn()).isEqualTo(0.0)
    }

    @Test
    fun `1등이 하나일 때 수익률은 2000000배`() {
        val report = Report(Ranks(listOf(Rank.FIRST)))

        assertThat(report.firstCount).isEqualTo(1)
        assertThat(report.getRateOfReturn()).isEqualTo(2_000_000.0)
    }

    @Test
    fun `2등이 하나일 때 수익률은 30000배`() {
        val report = Report(Ranks(listOf(Rank.SECOND)))

        assertThat(report.secondCount).isEqualTo(1)
        assertThat(report.getRateOfReturn()).isEqualTo(30_000.0)
    }

    @Test
    fun `3등이 하나일 때 수익률은 1500배`() {
        val report = Report(Ranks(listOf(Rank.THIRD)))

        assertThat(report.thirdCount).isEqualTo(1)
        assertThat(report.getRateOfReturn()).isEqualTo(1_500.0)
    }

    @Test
    fun `4등이 하나일 때 수익률은 50배`() {
        val report = Report(Ranks(listOf(Rank.FOURTH)))

        assertThat(report.fourthCount).isEqualTo(1)
        assertThat(report.getRateOfReturn()).isEqualTo(50.0)
    }

    @Test
    fun `5등이 하나일 때 수익률은 5배`() {
        val report = Report(Ranks(listOf(Rank.FIFTH)))

        assertThat(report.fifthCount).isEqualTo(1)
        assertThat(report.getRateOfReturn()).isEqualTo(5.0)
    }

    @Test
    fun `꽝이 하나일 때 수익률은 0배`() {
        val report = Report(Ranks(listOf(Rank.MISS)))

        assertThat(report.getRateOfReturn()).isEqualTo(0.0)
    }
}
