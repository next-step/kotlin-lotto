package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumbersTest {
    @Test
    fun `LottoNumbers에 교집합의 개수가 맞는지 테스트`() {
        val lottoAnswer = LottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3)
            )
        )

        val userPickedLotto = LottoNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(3),
                LottoNumber(5)
            )
        )

        val answer = lottoAnswer.intersectCount(userPickedLotto)
        val expect = 2

        assertThat(answer).isEqualTo(expect)
    }
}
