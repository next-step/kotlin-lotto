import org.junit.jupiter.api.Test

class NumberTest {
    @Test
    fun `음수 사용 불가능 테스트`() {
        org.junit.jupiter.api.assertThrows<RuntimeException> {
            Number(-1)
        }
    }
}