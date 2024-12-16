package lotto.domain

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @Test
    fun `같은 로또 번호가 동일한 객체로 반환한다`() {
        val lotto1 = LottoNumber.from(1)
        val lotto2 = LottoNumber.from(1)
        lotto1 shouldBe lotto2
        lotto1 shouldBeSameInstanceAs lotto2
    }

    @ParameterizedTest
    @ValueSource(ints = [60, 0, -10, 100])
    fun `생성할 수 없는 로또 번호를 테스트한다`(value: Int) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            LottoNumber.from(value)
        }
    }
}
