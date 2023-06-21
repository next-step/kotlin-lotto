package lotto.utils

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class StringUtilsTest {

    @Test
    fun `공백을 포함한 문자열을 콤마 기준으로 분리하여 문자열 리스트로 반환한다`() {
        val target = "1,2 ,3, 4, 5,6"
        val actual = StringUtils.replaceWhiteSpaceAndSplitByComma(target)
        actual.size shouldBe 6
        repeat(actual.size) {
            actual[it].length shouldBe 1
        }
    }

    @Test
    fun `문자열 타입 리스트를 정수형 타입 리스트로 변환 할 수 있다`() {
        val target = listOf("1", "2", "7", "4", "5", "6")
        val actual = StringUtils.convertStringToInt(target)
        actual.forEach {
            assertTrue(it is Int)
        }
    }
}
