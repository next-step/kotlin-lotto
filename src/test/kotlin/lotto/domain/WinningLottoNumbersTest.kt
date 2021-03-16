package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinningLottoNumbersTest {
    @Test
    fun `당첨 번호 갯수와 번호 검증`() {
        val winningLottoNumbers = WinningLottoNumbers.from("1, 2, 3, 4, 5, 6")

        assertThat(winningLottoNumbers.lottoNumbers.size).isEqualTo(6)
        assertThat(winningLottoNumbers.lottoNumbers[0]).isEqualTo(LottoNumber.from(1))
        assertThat(winningLottoNumbers.lottoNumbers[1]).isEqualTo(LottoNumber.from(2))
        assertThat(winningLottoNumbers.lottoNumbers[2]).isEqualTo(LottoNumber.from(3))
        assertThat(winningLottoNumbers.lottoNumbers[3]).isEqualTo(LottoNumber.from(4))
        assertThat(winningLottoNumbers.lottoNumbers[4]).isEqualTo(LottoNumber.from(5))
        assertThat(winningLottoNumbers.lottoNumbers[5]).isEqualTo(LottoNumber.from(6))
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1, 1, 2, 3, 4, 5",
            "1, 1, 1, 1, 1, 1",
            "45, 44, 43, 20, 20, 5"
        ]
    )
    fun `중복 번호 검증`(stringWinningLottoNumbers: String) {
        assertThrows<IllegalArgumentException> {
            WinningLottoNumbers.from(stringWinningLottoNumbers)
        }
    }
}
