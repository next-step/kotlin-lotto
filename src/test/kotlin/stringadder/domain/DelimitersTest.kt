package stringadder.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class DelimitersTest {

    @DisplayName("인자 없이 생성한 경우 기본 구분자로 구성된 객체 반환")
    @Test
    fun constructor() {
        assertThat(Delimiters().list).contains(",", ":")
    }

    @DisplayName("구분자를 인자로 생성한 경우 구분자가 추가된 객체 반환")
    @Test
    fun constructor_additional() {
        val customDelimiter = "shakeVan"
        assertThat(Delimiters(customDelimiter).list).contains(",", ":", customDelimiter)
    }
}