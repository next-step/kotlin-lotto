package lotto.util

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RandomUtilTest {
    @Test
    fun `특정 숫자 범위에서 입력한 개수만큼 랜덤 숫자가 생성된다`() {
        val sut = RandomUtil
        val result = sut.getShuffledNumbers(intRange = 1..45, size = 6)
        result.map { number -> assertThat(number).isBetween(1, 45) }
        assertEquals(6, result.size)
    }
}
