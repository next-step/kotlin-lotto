package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StringNumberCollectionTest {

    @Test
    fun `stringNumbers 의 합을 반환한다`() {
        // given
        val stringNumberCollection = StringNumberCollection(listOf(StringNumber("1"), StringNumber("2")))
        val expectResult = 1 + 2

        // when
        val result = stringNumberCollection.add()

        // then
        assertThat(result).isEqualTo(expectResult)
    }
}
