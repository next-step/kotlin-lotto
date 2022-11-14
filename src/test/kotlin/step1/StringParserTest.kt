package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StringParserTest{

    @Test
    fun `Default separator 로 문자열이 파싱 되어 리스트를 반환한다`(){
        //when
        val strings = StringParser.splitBySeparator("1,2:3")
        //then
        assertThat(strings[0]).isEqualTo("1")
        assertThat(strings[1]).isEqualTo("2")
        assertThat(strings[2]).isEqualTo("3")
    }

    @Test
    fun `Custom separator 로 문자열이 파싱 되어 리스트를 반환한다`(){
        //when
        val strings = StringParser.splitBySeparator("//;\n1;2;3")
        //then
        assertThat(strings[0]).isEqualTo("1")
        assertThat(strings[1]).isEqualTo("2")
        assertThat(strings[2]).isEqualTo("3")
    }
}
