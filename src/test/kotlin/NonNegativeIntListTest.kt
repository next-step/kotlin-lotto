import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

class NonNegativeIntListTest {
    @Test
    fun `음수가 아닌 Int 목록을 생성한다`() {
        assertThat(NonNegativeIntList.of(listOf("1", "2"))).containsExactlyInAnyOrder(1, 2)
    }

    @Test
    fun `음수는 예외를 발생한다`() {
        assertThrows<RuntimeException> { NonNegativeIntList.of(listOf("1", "-2")) }
    }

    data class NonNegativeIntList(private val nonNegativeIntList: List<Int>) : List<Int> by nonNegativeIntList {
        companion object {
            fun of(numericStringList: List<String>): NonNegativeIntList {
                return numericStringList.map {
                    it.toInt()
                }.let { NonNegativeIntList(it) }
            }
        }
    }
}
