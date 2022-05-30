package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.ListAssert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.converter.ConvertWith
import org.junit.jupiter.params.converter.SimpleArgumentConverter
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    @Test
    fun `Lotto has 6 numbers between 1 to 45`() {
        val inputNumbers = setOf(1, 2, 3, 4, 5, 6)

        val lotto = Lotto(inputNumbers)

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
            Lotto(inputNumbers.map { it.toInt() }.toSet())
        }
    }

    @Test
    fun `check price result`() {
        val winner = Lotto(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        val firstPriceLotto = Lotto(1, 2, 3, 4, 5, 6)
        val secondPriceLotto = Lotto(7, 1, 2, 3, 4, 5)
        val thirdPriceLotto = Lotto(1, 2, 3, 4, 5, 8)
        val fourthPriceLotto = Lotto(1, 2, 3, 4, 9, 8)
        val fifthPriceLotto = Lotto(10, 2, 3, 4, 9, 8)
        val nonePriceLotto = Lotto(8, 9, 10, 11, 12, 13)
        val inputList = listOf(
            firstPriceLotto, secondPriceLotto, thirdPriceLotto,
            fourthPriceLotto, fifthPriceLotto, nonePriceLotto
        )

        ListAssert(inputList.map { it.checkResult(winner, bonusNumber) })
            .isEqualTo(listOf(Price.FIRST, Price.SECOND, Price.THIRD, Price.FOURTH, Price.FIFTH, Price.NONE))
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
