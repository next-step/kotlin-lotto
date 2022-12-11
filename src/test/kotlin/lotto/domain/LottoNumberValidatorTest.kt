package lotto.domain

import io.kotest.matchers.shouldBe
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberValidatorTest {

    @DisplayName("숫자로 변환 할 수 없는 스트링이 입력되면 예외 처리한다")
    @Test
    fun validate() {
        val input = "1,2,3,4,5,6"
        LottoNumberValidator.validate(input) shouldBe true
    }

    @DisplayName("숫자로 변환 할 수 없는 스트링이 입력되면 예외 처리한다")
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5,a"])
    fun nonNumberString(input: String) {
        assertThatExceptionOfType(IllegalStateException::class.java).isThrownBy {
            LottoNumberValidator.validate(input)
        }
    }

    @DisplayName("빈 값 또는 null 값인 스트링이 입력되면 예외 처리한다")
    @ParameterizedTest
    @NullAndEmptySource
    fun nullAndEmpty(input: String?) {
        assertThatExceptionOfType(IllegalStateException::class.java).isThrownBy {
            LottoNumberValidator.validate(input)
        }
    }

    @DisplayName("보너스 숫자가 로또 숫자이면 true")
    @Test
    internal fun bonusNumber() {
        val bonusNumber = "7"

        val result = LottoNumberValidator.validateBonus(bonusNumber)

        result shouldBe true
    }

    @DisplayName("보너스 숫자가 로또 숫자 범위를 초과한 거라면 false")
    @ParameterizedTest
    @ValueSource(strings = ["", "99"])
    internal fun noneBonusNumber(input: String) {
        val result = LottoNumberValidator.validateBonus(input)

        result shouldBe false
    }

    @DisplayName("보너스 숫자가 로또 숫자가 아니라면 false")
    @ParameterizedTest
    @ValueSource(strings = ["A"])
    internal fun noneNumber(input: String) {
        assertThatExceptionOfType(IllegalStateException::class.java).isThrownBy {
            LottoNumberValidator.validateBonus(input)
        }
    }

    @DisplayName("보너스 숫자가 1개 초과 되면 false")
    @Test
    internal fun singleBonusNumber() {
        val bonusNumber = "1,2"

        val result = LottoNumberValidator.validateBonus(bonusNumber)

        result shouldBe false
    }
}
