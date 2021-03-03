import org.junit.jupiter.api.Test

class LettersTest {
    @Test
    fun `표현식으로부터 글자 리스트 표현한다`() {
        assertThat(Letters(Expression("1,2"))).isEqualTo(listOf("1, 2"))
    }
}
