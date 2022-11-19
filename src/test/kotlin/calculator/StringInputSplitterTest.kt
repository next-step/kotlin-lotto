package calculator

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException
import java.math.BigDecimal

internal class StringInputSplitterTest {

    @ParameterizedTest
    @ValueSource(strings = ["가,나,다", "~,2,3", "1,,3"])
    fun `stringToBigDecimalList throw RuntimeException when not Number`(stringNumber: String) {
        val exception = assertThrows<RuntimeException> {
            StringInputSplitter.stringToBigDecimalList(stringNumber)
        }
        assertThat(exception.message).isEqualTo(MessageCode.NotNumber.message)
    }

    @NullAndEmptySource
    @ParameterizedTest
    fun `stringToBigDecimalList with null or empty should be zero`(stringNumber: String?) {
        val result = StringInputSplitter.stringToBigDecimalList(stringNumber)

        result?.first() shouldBe BigDecimal.ZERO
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "1,2:3", "//;\\n1;2;3"])
    fun stringToBigDecimalList(stringNumber: String) {
        val result = StringInputSplitter.stringToBigDecimalList(stringNumber)

        val resultNumber = listOf(1, 2, 3)
        result?.forEachIndexed { index, number ->
            number shouldBe resultNumber[index].toBigDecimal()
        }
    }
}
