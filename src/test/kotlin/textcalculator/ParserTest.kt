package textcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParserTest {
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
    fun `checkIfCustomPrefix() 프리픽스로 커스텀 구분자 있으면 spliter에 추가`(text: String) {
        val parser = Parser()
        assertThat(parser.spliter).contains(":", ",").hasSize(2)

        parser.checkIfCustomPrefix("//$text\\n1:1:1")

        assertThat(parser.spliter).contains(":", ",", text).hasSize(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1:1", "1;2:3", "1212asd"])
    fun `checkIfCustomPrefix() 프리픽스 제거하고 나머지 문자열을 반환`(text: String) {
        assertThat(
            Parser().checkIfCustomPrefix("//;\\n$text")
        ).isEqualTo(text)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1:1", "1;2:3", "1212asd"])
    fun `checkIfCustomPrefix() 해당되는 문자열 없으면 문자열 원본을 반환`(text: String) {
        assertThat(
            Parser().checkIfCustomPrefix(text)
        ).isEqualTo(text)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1:1:1", "1;2:3", "//\\n1212asd"])
    fun `checkIfCustomPrefix() 해당되는 문자열 없으면 구분자 추가 없음`(text: String) {
        val parser = Parser()
        parser.checkIfCustomPrefix(text)

        assertThat(parser.spliter).contains(":", ",").hasSize(2)
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
}
