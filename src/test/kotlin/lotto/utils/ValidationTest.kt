package lotto.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class ValidationTest {

    @Test
    @DisplayName("숫자가 아닌 문자가 들어오거나 포함된 경우 false를 반환")
    fun `Returns false if non-numeric characters are entered or included`() {
        val isNumeric = Validation.isNumeric("123a")
        assertThat(isNumeric).isFalse
    }

    @Test
    @DisplayName("숫자 1이 기준 범위 1에서 45까지 포함된 경우 true를 반환")
    fun `Returns true if the number 1 contains a reference range from 1 to 45`() {
        val isWithInRange = Validation.isWithInRange("1", 1..45)
        assertThat(isWithInRange).isTrue
    }

    @Test
    @DisplayName("[1] 배열의 길이가 기준 길이 1과 같을 경우 true를 반환")
    fun `Returns true if the length of the array is equal to the reference length of 1`() {
        val list = listOf(1)
        val isSame = Validation.isSameNumberOfArraysAndReferenceValue(list.size, 1)
        assertThat(isSame).isTrue
    }

    @Test
    @DisplayName("공백일 경우 false를 반환")
    fun `Returns false if blank`() {
        val isNotBlank = Validation.isNotBlank("")
        assertThat(isNotBlank).isFalse
    }
}
