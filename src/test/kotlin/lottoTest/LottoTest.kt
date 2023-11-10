package lottoTest

import lotto.domain.Lotto
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,1,1,1,1,1"])
    fun `로또는 겹치는 숫자가 없음`(input: String) {
        assertThatThrownBy {
            Lotto(
                input.split(",").map { it.toInt() }
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @MethodSource("generateIllegalLottoNumbers")
    fun `로또는 지정된 범위 내의 숫자만 선택 가능`(input: List<Int>) {
        assertThatThrownBy {
            Lotto(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        fun generateIllegalLottoNumbers(): List<Arguments> {
            return listOf(
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, Lotto.MAX_LOTTO_NUMBER + 1)
                ),
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, Lotto.MIN_LOTTO_NUMBER - 1)
                )
            )
        }
    }
}
