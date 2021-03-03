import org.junit.jupiter.api.Test

class SumTest {
    @Test
    fun `숫자 리스트를 모두 더한다`() {
        assertThat(Sum(listOf(1, 2)).toInt()).isEqualTo(3)
    }
}
