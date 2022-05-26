package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Test
    fun `LottoNumbers에 교집합의 개수가 맞는지 테스트`() {
        val numbers1 = LottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3)
            )
        )

        val numbers2 = LottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(3),
                LottoNumber(5)
            )
        )

        val answer = numbers1.intersectCount(numbers2)
        val expect = 2

        assertThat(answer).isEqualTo(expect)
    }
}
