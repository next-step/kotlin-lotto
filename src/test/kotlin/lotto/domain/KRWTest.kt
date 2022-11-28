package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class KRWTest {

    @Test
    fun `0 미만의 값은 생성되지 않는다`() {
        assertThrows<IllegalArgumentException> {
            KRW(-1)
        }
    }

    @Test
    fun `1000으로 나눴을 때 나머지가 있는 값은 생성되지 않는다`() {
        assertThrows<IllegalArgumentException> {
            KRW(1300)
        }
    }

    @DisplayName("밸류 생성 테스트")
    @ParameterizedTest(name = "{0}는 생성된다")
    @ValueSource(ints = [0, 1000, 2000, 3000])
    fun `밸류 생성 테스트`(money: Int) {
        assertThat(KRW(money)).isEqualTo(KRW(money))
    }
}
