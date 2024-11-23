package study

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class KotlinStudyTest {
    private val input = "//;\n"

    @Test
    fun `정규식을 사용해서 문자열 추출`() {
        val regex = Regex("//(.*)\n")

        val matchResult = regex.find(input)!!  // 학습 테스트이기 때문에 널 아님 단언 사용
        val extractedString = matchResult.groups[1]?.value

        assertThat(extractedString).isEqualTo(";")
    }

    @Test
    fun `정규식 groups 이해해보기`() {
        val regex = Regex("(\\d+)-(\\w+)+")
        val input = "123-abc"
        val matchResult = regex.find(input)!!

        assertAll(
            { assertThat(matchResult.groups[0]?.value).isEqualTo("123-abc") },
            { assertThat(matchResult.groups[1]?.value).isEqualTo("123") },
            { assertThat(matchResult.groups[2]?.value).isEqualTo("abc") },
        )
    }

    @Test
    fun `substring을 사용해서 문자열 추출`() {
        val substringAfter = input.substringAfter("//")
        assertThat(substringAfter).isEqualTo(";\n")

        val substringBefore = substringAfter.substringBefore("\n")
        assertThat(substringBefore).isEqualTo(";")
    }

    @Test
    fun `split 함수를 사용해 문자열 추출`() {
        val split = input.split("//", "\n")

        assertThat(split).isEqualTo(listOf("", ";", ""))
    }
}