package calculator

import calculator.ExpressionTest.Expression
import calculator.NonNegativeIntListTest.NonNegativeIntList
import calculator.SplittedTest.Splitted
import calculator.SumTest.Sum
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class IntegrationTest {
    @Test
    fun `문자열 덧셈 계산기 동작 확인`() {
        assertAll(
            {
                assertThat(
                    Sum(
                        NonNegativeIntList.of(
                            Splitted(
                                Expression(
                                    "1,2,3"
                                )
                            )
                        )
                    ).toInt()
                ).isEqualTo(6)
            },
            {
                assertThat(
                    Sum(
                        NonNegativeIntList.of(
                            Splitted(
                                Expression(
                                    "1,2:3"
                                )
                            )
                        )
                    ).toInt()
                ).isEqualTo(6)
            },
            {
                assertThat(
                    Sum(
                        NonNegativeIntList.of(
                            Splitted(
                                Expression(
                                    "//;\n1;2;3"
                                )
                            )
                        )
                    ).toInt()
                ).isEqualTo(6)
            },
            {
                assertThat(
                    Sum(
                        NonNegativeIntList.of(
                            Splitted(
                                Expression(
                                    ""
                                )
                            )
                        )
                    ).toInt()
                ).isEqualTo(0)
            }
        )
    }
}
