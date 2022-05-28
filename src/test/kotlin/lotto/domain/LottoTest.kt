package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.converter.SimpleArgumentConverter
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    @Test
    fun `Lotto has 6 numbers between 1 to 45`() {
        val inputNumbers = listOf(1, 2, 3, 4, 5, 6)

        val lotto = Lotto(*inputNumbers.toIntArray())

        assertThat(lotto).extracting("numbers").isEqualTo(inputNumbers)
    }

    @ParameterizedTest
    @CsvSource(
        "'1;2;3;4;5'",
        "'123;45;6;1;2;3'"
    )
    fun `Lotto throw IllegalArgumentsException for wrong numbers`(
        @ConvertWith(StringArrayConverter::class) inputNumbers: Array<String>
    ) {
        assertThrows<IllegalArgumentException> {
            Lotto(inputNumbers.map { it.toInt() })
        }
    }

    class StringArrayConverter : SimpleArgumentConverter() {
        override fun convert(source: Any, targetType: Class<*>): Any {
            return if (source is String && Array<String>::class.java.isAssignableFrom(targetType)) {
                source.split("\\s*;\\s*".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            } else {
                throw IllegalArgumentException(
                    "Conversion from " + source.javaClass + " to " +
                        targetType + " not supported."
                )
            }
        }
    }
}
