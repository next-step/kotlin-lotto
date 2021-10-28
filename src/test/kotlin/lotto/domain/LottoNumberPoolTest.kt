package lotto.domain

import lotto.domain.LottoNumber.Companion.MAXIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumber.Companion.MINIMUM_LOTTO_NUMBER
import lotto.domain.LottoNumberPackage.Companion.LOTTO_GAME_NUMBER_COUNT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class LottoNumberPoolTest {
    @Test
    fun `getShuffledLottoNumbers() 함수를 호출하면 1~45 사이의 로또 번호 6개가 생성된다`() {
        val shuffledLottoNumbers = LottoNumber.getShuffledLottoNumbers()

        assertThat(shuffledLottoNumbers).isNotNull
        assertThat(shuffledLottoNumbers.size).isEqualTo(LOTTO_GAME_NUMBER_COUNT)

        shuffledLottoNumbers.forEach {
            assertTrue(it >= MINIMUM_LOTTO_NUMBER && it <= MAXIMUM_LOTTO_NUMBER)
        }
    }
}
