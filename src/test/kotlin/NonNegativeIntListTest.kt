import org.junit.jupiter.api.Test

class NonNegativeIntListTest {
    @Test
    fun `음수가 아닌 Int 목록을 생성한다`() {
        assertThat(NonNegativeIntList(["1", "2"])).containsExactlyInAnyOrder(1, 2)
    }
}
