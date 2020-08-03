package textcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParserTest {
    @Test
    internal fun foo() {
        Regex("^(\\/\\/)(.)(\\\\n)(.*)")
            .find("1;2;3")
    }

    @Test
    fun `split() 문자열을 구분자로 쪼갠다`() {
        Parser().apply {
            assertThat("1:1:2,33".split()).isEqualTo(
                listOf("1", "1", "2", "33")
            )
        }
    }

    @Test
    fun `spliter의 초기 값은 콜론과 콤마`() {
        assertThat(
            Parser().spliter
        ).contains(":", ",").hasSize(2)
    }

    @ParameterizedTest
    @ValueSource(strings = [";", "_", "-", "a", "$"])
    fun `addCustomDelimiter() 프리픽스로 커스텀 구분자 있으면 spliter에 추가`(text: String) {
        val parser = Parser()
        assertThat(parser.spliter).contains(":", ",").hasSize(2)

        parser.addCustomDelimiter("$text")

        assertThat(parser.spliter).contains(":", ",", text).hasSize(3)
    }

    @Test
    fun `addCustomDelimiter() 공백은 spliter에 추가되지 않음`() {
        val parser = Parser()
        assertThat(parser.spliter).contains(":", ",").hasSize(2)

        parser.addCustomDelimiter("")

        assertThat(parser.spliter).contains(":", ",").hasSize(2)
    }

    @Test
    fun `getCustomDelimiter() 프리픽스가 있으면 추출`() {
        Parser().apply {
            val result = divideByRegex("//;\\n1:1:1")
            assertThat(result.getCustomDelimiter()).isEqualTo(";")
        }
    }

    @Test
    fun `getCustomDelimiter() 프리픽스가 없으면 공백`() {
        Parser().apply {
            val result = divideByRegex("1:1:1")
            assertThat(result.getCustomDelimiter()).isEqualTo("")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\\n1:1:1", "1:1:1"])
    fun `getMainText() 프리픽스가 있든 없든 메인텍스트 추출`(text: String) {
        Parser().apply {
            val result = divideByRegex(text)
            assertThat(result.getMainText()).isEqualTo("1:1:1")
        }
    }

    @Test
    fun `toInts() String 리스트를 Int 리스트로 변환`() {
        Parser().apply {
            assertThat(
                listOf("1", "12", "123", "12345").toInts()
            ).isEqualTo(
                listOf(1, 12, 123, 12345)
            )
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "_", "aa", "1.0", "a11"])
    fun `toInts() 음수나 다른 문자열이 섞여 있으면 RuntimeException`(text: String) {
        Parser().apply {
            assertThatThrownBy {
                listOf(text).toInts()
            }.isInstanceOf(RuntimeException::class.java)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1:1", "1,2:3", "1,2,1,2"])
    fun `parse() 커스텀 프리픽스 없으면 구분자 추가 없음`(text: String) {
        val parser = Parser()
        parser.parse(text)

        assertThat(parser.spliter).contains(":", ",").hasSize(2)
    }

    @ParameterizedTest
    @ValueSource(strings = [";", "_", "-", ".", "~"])
    fun `parse() 커스텀 프리픽스 있으면 구분자 추가`(text: String) {
        val parser = Parser()
        parser.parse("//$text\\n1${text}2${text}3${text}4")

        assertThat(parser.spliter).contains(":", ",", text).hasSize(3)
    }

    @Test
    fun `parse() 정상 케이스일 때 정수 리스트 반환`() {
        assertThat(
            Parser().parse("1:0,2:3,44")
        ).isEqualTo(
            listOf(1, 0, 2, 3, 44)
        )
    }

    @Test
    fun `parse() 프리픽스 있는 정상 케이스일 때 정수 리스트 반환`() {
        assertThat(
            Parser().parse("//;\\n1:0,2:3;44")
        ).isEqualTo(
            listOf(1, 0, 2, 3, 44)
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "_", "aa", "1.0", "a11"])
    fun `parse() 음수 또는 잘못된 문자열 있으면 RuntimeException`(text: String) {
        assertThatThrownBy {
            Parser().parse("1:0,2:3,$text")
        }.isInstanceOf(RuntimeException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = [";", "_", "-", ".", "~"])
    fun `divideByRegex() 커스텀 인자가 있다면 Group3으로 반환`(text: String) {
        assertThat(Parser().divideByRegex("//$text\\n").groupValues[3])
            .isEqualTo(text)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1", "1,1,1", "-", "", "1;1;1"])
    fun `divideByRegex() 커스텀 인자가 없다면 Group3 공백`(text: String) {
        assertThat(Parser().divideByRegex("$text").groupValues[3])
            .isEqualTo("")
    }

    @ParameterizedTest
    @ValueSource(strings = [";", "_", "-", ".", "~"])
    fun `divideByRegex() 커스텀 인자가 있어도 Group5로 나머지 메인 문자열만 반환`(text: String) {
        assertThat(Parser().divideByRegex("//$text\\n1:2:3,4").groupValues[5])
            .isEqualTo("1:2:3,4")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1", "1,1,1", "1;1;1"])
    fun `divideByRegex() 커스텀 인자가 없으면 Group5로 똑같은 문자열 반환`(text: String) {
        assertThat(Parser().divideByRegex("$text").groupValues[5])
            .isEqualTo(text)
    }
}
