package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `총 6개의 랜덤한 숫자로 된 로또를 생성할 수 있다`() {
        val lottoNumbers = Lotto().numbers.list

        assertThat(lottoNumbers).hasSize(6)
    }

    @Test
    fun `총 6개의 커스텀 숫자로 된 로또를 생성할 수 있다`() {
        val lottoNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6)).numbers.list

        assertThat(lottoNumbers).hasSize(6)
    }
}
