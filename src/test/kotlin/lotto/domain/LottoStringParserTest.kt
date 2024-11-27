package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class LottoStringParserTest {

    @ParameterizedTest
    @MethodSource("provideInvalidateValue")
    fun `유효하지 않은 값을 입력하면 예외를 던진다`(input: String) {
        // given
        val lottoStringParser = LottoStringParser()

        // when & then
        assertThatThrownBy { lottoStringParser.parse(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("로또 숫자의 범위는 ${LottoGenerator.RANGE} 입니다")
    }

    companion object {

        @JvmStatic
        fun provideInvalidateValue(): List<String> {
            return listOf(
                "-1,1,2,3,4,5",
                "stringvalue",
                "str,1,2,3,4,5",
                "46,1,2,3,4,5",
            )
        }

    }

}
