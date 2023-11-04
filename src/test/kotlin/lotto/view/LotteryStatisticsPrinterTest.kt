package lotto.view

import lotto.business.LotteryStatistics
import lotto.business.ProfitRate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class LotteryStatisticsPrinterTest {
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun tearDown() {
        System.setOut(standardOut)
    }

    @Test
    fun `당첨 통계를 출력한다`() {
        // given
        val lotteryStatistics = LotteryStatistics(1, 2, 3, 4)
        val profitRate = ProfitRate(0.5)

        // when
        LotteryStatisticsPrinter.print(lotteryStatistics, profitRate)

        // then
        assertThat(outputStreamCaptor.toString()).isEqualTo(
            """
            통계
            ---------
            3개 일치 (5000원) - 1개
            4개 일치 (50000원) - 2개
            5개 일치 (1500000원) - 3개
            6개 일치 (2000000000원) - 4개
            총 수익률은 0.5입니다.
            
            """
                .trimIndent()
        )
    }
}
