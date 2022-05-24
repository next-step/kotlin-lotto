package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IntersectStudyTest {

    @Test
    fun `intersect로 교집합 추출한다`() {
        val list1 = listOf(1, 2, 3, 4, 5, 6, 7)
        val intRange = 5..10

        val result = list1.intersect(intRange).toList()
        val expectResult = listOf(5, 6, 7)

        assertThat(result).isEqualTo(expectResult)
    }
}
