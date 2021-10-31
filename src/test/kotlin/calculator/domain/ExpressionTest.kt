package calculator.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class ExpressionTest {

    @ParameterizedTest
    @MethodSource("올바른_사용자_입력과_구분자")
    fun `사용자 입력으로 부터 구분자로 사용할 문자를 파싱할 수 있다`(input: String, symbol: String) {
        Assertions.assertThat(Expression.of(input).delimiter.symbol).isEqualTo(symbol)
    }

    @ParameterizedTest
    @MethodSource("올바른_사용자_입력과_피연산자_리스트")
    fun `사용자 입력으로 부터 피연산자들을 파싱할 수 있다`(input: String, values: List<String>) {
        Assertions.assertThat(Expression.of(input).operands).isEqualTo(Operands.of(values))
    }

    companion object {
        @JvmStatic
        fun `올바른_사용자_입력과_구분자`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//;\n1;2;3", ";"),
                Arguments.of("//.\n3.6.7", "."),
                Arguments.of("//:\n1:2:3", ":"),
                Arguments.of("1,2,3", ",|:")
            )
        }

        @JvmStatic
        fun `올바른_사용자_입력과_피연산자_리스트`(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("//;\n1;2;3", listOf("1", "2", "3")),
                Arguments.of("//.\n3.6.7", listOf("3", "6", "7")),
                Arguments.of("//:\n1:2:3", listOf("1", "2", "3")),
                Arguments.of("1,2,3", listOf("1", "2", "3"))
            )
        }
    }
}
