package lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

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
    @DisplayName("게임의 로또 번호가 1,2,3,4,5,6일 경우 [1, 2, 3, 4, 5, 6]를 반환")
    fun `Print the purchased number`() {
        val purchasedNumber = ResultView.purchasedNumber(listOf(1, 2, 3, 4, 5, 6))
        assertThat(purchasedNumber).isEqualTo("[1, 2, 3, 4, 5, 6]")
    }
}
