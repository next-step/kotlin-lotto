package lotto.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayInputStream

internal class InputViewTest {

    @ParameterizedTest
    @DisplayName("최소 구매 비용이 1000이고 입력 값이 13500일 경우 잔돈은 500을 반환")
    @ValueSource(strings = ["13500\n5"])
    fun `If the minimum purchase cost is 1000 and the input value is 13500, the change returns 500`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)
        val purchaseResult = InputView.purchaseCost()

        assertThat(purchaseResult.change).isEqualTo(500)
    }

    @ParameterizedTest
    @DisplayName("최소 구매 비용이 1000이고 입력 값이 13500일 경우 게임 횟수 13을 반환")
    @ValueSource(strings = ["13500\n5"])
    fun `Return 13 games if minimum purchase cost is 1000 and input value is 13500`(input: String) {
        val inputStream = InputStream.generate(input)
        System.setIn(inputStream)
        val purchaseResult = InputView.purchaseCost()

        assertThat(purchaseResult.numberOfGames).isEqualTo(13)
    }

    object InputStream {
        fun generate(input: String) = ByteArrayInputStream(input.toByteArray())
    }
}
