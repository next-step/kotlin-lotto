package view.buyinginput

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import view.BuyingInput
import view.BuyingInputParsedResult
import view.InvalidInput

internal class BuyingInputParserTest {
    @ParameterizedTest
    @ValueSource(strings = ["a", "*"])
    fun `Long 타입이 아니면 InvalidResult울 반환`(input: String) {
        // given
        val expected = InvalidInput(input, "숫자가 아닙니다. 다시 입력해 주세요.")

        // when
        val actual: BuyingInputParsedResult = BuyingInputParser.parse(input)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Lotto 구입금액보다 적은 값이면 LessThanOneLottoAmount를 반환`() {
        // given
        val input = "800"
        val expected = InvalidInput("800", "액수가 로또 한 장보다 적습니다. 다시 입력해 주세요.")

        // when
        val actual: BuyingInputParsedResult = BuyingInputParser.parse(input)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `Lotto 한 개 구입금액 이상이면 BuyingInput을 반환`() {
        val input = "1000"

        val result: BuyingInputParsedResult = BuyingInputParser.parse(input)

        assertThat(result).isEqualTo(BuyingInput(1000))
    }
}
