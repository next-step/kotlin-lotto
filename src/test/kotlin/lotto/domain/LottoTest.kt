package lotto.domain

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.Lotto.Companion.LOTTO_NUMBER_RANGE
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `RandomNumberGenerator를 생성자 파라미터로 받아 임의의 값으로 초기화한다`() {
        val lotto = Lotto(RandomNumberGenerator())
        Assertions.assertThat(LOTTO_NUMBER_RANGE.count { number -> lotto.contains(LottoNumber(number)) })
            .isEqualTo(LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `숫자목록 생성자 파라미터로 받아 임의의 값으로 초기화한다`() {
        val numbers = listOf(1, 5, 7, 11, 25, 45).map { LottoNumber(it) }
        val lotto = Lotto(numbers)

        LOTTO_NUMBER_RANGE.forEach {
            val lottoNumber = LottoNumber(it)
            Assertions.assertThat(lotto.contains(lottoNumber)).isEqualTo(numbers.contains(lottoNumber))
        }
    }
}
