package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoTest {
    @ParameterizedTest
    @ValueSource(strings = ["1,2,3,4,5", "1,2,3,4,5,6,7"])
    fun `잘못된 개수의 번호로 로또 생성 시 에러를 일으킨다`(numbers: String) {
        assertThrows<IllegalArgumentException> {
            Lotto(numbers.split(",").map { it.toInt() })
        }
    }

    @Test
    fun `중복된 번호로 로또 생성 시 에러를 일으킨다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 2, 3, 4, 5))
        }
    }
}
