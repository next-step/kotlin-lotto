package stringaddcalculator.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class DefaultSplitterTest {

    @Test
    @DisplayName("기본 splitter는 성능상의 이점을 위해 싱글턴이다")
    fun split() {
        val defaultSplitter = DefaultSplitter
        val defaultSplitter2 = DefaultSplitter
        assertThat(defaultSplitter).isEqualTo(defaultSplitter2)
    }
}
