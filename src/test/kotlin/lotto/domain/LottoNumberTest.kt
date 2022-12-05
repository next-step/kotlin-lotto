package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoNumberTest {

    @Test
    fun `0 이하의 값은 생성되지 않는다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(0)
        }
    }

    @Test
    fun `46이상의 값은 생성되지 않는다`() {
        assertThrows<IllegalArgumentException> {
            LottoNumber(46)
        }
    }

    @DisplayName("밸류 생성 테스트")
    @ParameterizedTest(name = "{0}는 생성된다")
    @MethodSource("oneToFortyFive")
    fun `밸류 생성 테스트`(money: Int) {
        Assertions.assertThat(LottoNumber(money)).isEqualTo(LottoNumber(money))
    }

    companion object {
        @JvmStatic
        fun oneToFortyFive(): List<Arguments> {

            return IntRange(1, 45).map {
                Arguments.of(it)
            }.toList()
        }
    }
}
