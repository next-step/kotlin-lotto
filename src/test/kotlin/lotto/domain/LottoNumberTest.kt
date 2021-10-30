package lotto.domain

import lotto.exception.IllegalLottoNumberException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @DisplayName("로또의 번호는 1과 45 사이의 숫자여야만 한다.")
    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46, 47])
    fun `잘못된 번호`(number: Int) {
        assertThatExceptionOfType(IllegalLottoNumberException::class.java)
            .isThrownBy { LottoNumber(number) }
    }

    @TestFactory
    fun equals() = (LottoNumber.MIN..LottoNumber.MAX).map {
        DynamicTest.dynamicTest("로또의 번호가 같으면 같은 객체로 인식되어야 한다. $it") {
            assertThat(LottoNumber(it))
                .isEqualTo(LottoNumber(it))
        }
    }
}
