package lotto.view

import lotto.domain.lotto.LottoNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.math.BigDecimal

internal class ResultViewTest {

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
    @DisplayName("게임의 로또 번호가 1,2,3,4,5,6일 경우 [1, 2, 3, 4, 5, 6]를 출력")
    fun `Print the purchased number`() {
        ResultView.printChosenNumber(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        assertThat(outputStreamCaptor.toString().trim { it <= ' ' }).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }

    @Test
    @DisplayName("비율이 0.5일 경우 손해를 출력")
    fun `Print the purchased number2`() {
        ResultView.printRate(BigDecimal(0.5))
        assertThat(
            outputStreamCaptor.toString().trim { it <= ' ' }
        ).isEqualTo("총 수익률은 0.5입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
    }
}
