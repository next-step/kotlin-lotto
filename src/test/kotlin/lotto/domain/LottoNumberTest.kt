package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @Test
    fun `로또번호는 번호값으로 캐시된다`() {
        (1..45).forEach {
            assertThat(LottoNumber.from(it) == LottoNumber.from(it)).isTrue()
            assertThat(LottoNumber.from(it) === LottoNumber.from(it)).isTrue()
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46, -1, 100, 99, 1000])
    fun `로또 번호는 1 부터 45 이외의 값으로 생성시 예외가 발생한다`(number: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber.from(number)
        }
    }

    @Test
    fun `associateWith로 만드는 로또 번호 캐시맵 테스트`() {
        val cache1: Map<Int, LottoNumber> = (1..45).map {
            Pair(it, LottoNumber.from(it))
        }.toMap()

        val cache2: Map<Int, LottoNumber> = (1..45).associateWith { LottoNumber.from(it) }

        assertThat(cache1.size).isEqualTo(cache2.size)

        (1..45).forEach {
            assertThat(cache1[it]).isEqualTo(cache2[it])
        }
    }
}
