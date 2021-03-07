package stringaddcalculator.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class SplitterTest {

    @Test
    @DisplayName("기본 구분자인 ,와 :를 사용하여 문자열을 나눌 수 있다.")
    fun split() {
        val splitList = Splitter().split("1,2:3")
        assertThat(splitList).containsSequence("1", "2", "3")
    }

    @Test
    @DisplayName("커스텀 구분자를 설정하여 문자열을 나눌 수 있다")
    fun customSplit() {
        val splitList = Splitter(";").split("1;2;3")
        assertThat(splitList).containsSequence("1", "2", "3")
    }

    @Test
    @DisplayName("커스텀 구분자를 설정하면 기본 구분자는 사용되지 않는다")
    fun customSplitWithDefault() {
        val splitList = Splitter(";").split("1,2;3:4")
        assertThat(splitList).containsSequence("1,2", "3:4")
    }
}
