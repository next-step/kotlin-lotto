package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StudyTest {
    @Test
    fun `split with blank`() {
        assertThat("123".split("")).containsExactly("", "1", "2", "3", "")
    }

    @Test
    fun `regex find test`() {
        val result = Regex("""//(.)\n(.*)""").find("//;\n")
        assertThat(result).isNotNull
        assertThat(result?.value).isEqualTo("//;\n")
    }

    @Test
    fun `regex find test with prefix`() {
        val result = Regex("""//(.)\n""").find("ddd//;\n33;3;3")
        assertThat(result).isNotNull
        assertThat(result?.value).isEqualTo("//;\n")
    }

    @Test
    fun `regex replace test with prefix`() {
        val result = Regex("""//(.)\n""").replace("ddd//;\neee", "")
        assertThat(result).isEqualTo("dddeee")
    }

    @Test
    fun `string with`() {
        assertThat("asdfaaaa".startsWith("asdf")).isTrue()
    }

    @Test
    fun `substring`() {
        val str = "abcd"
        assertThat(str.substring(0..0)).isEqualTo("a")
    }

    @Test
    fun `toInt of value less than 0`() {
        assertThat("-1".toInt()).isEqualTo(-1)
    }

    @Test
    fun `toInt of value less than 0 with split`() {
        val nums = "-1,-1".split(",").map { it.toInt() }
        assertThat(nums).contains(-1, -1)
    }

    @Test
    fun `split with space`() {
        val list = "1, 2, 3, 4, 5".split(", ").map { it.toInt() }
        assertThat(list).contains(1, 2, 3, 4, 5)
    }
}
