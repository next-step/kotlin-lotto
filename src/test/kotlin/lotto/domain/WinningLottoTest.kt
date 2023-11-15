package lotto.domain

import lotto.enums.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class WinningLottoTest {

    @Test
    fun `당첨번호6개와 보너스 번호1개를 주입하여 당첨로또를 생성한다`() {
        // Given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 7

        // When
        val actual = WinningLotto(
            Lotto.from(winningNumbers), LottoNumber.from(bonusNumber)
        )

        // Then
        assertAll(
            {
                val expectedLottoNumbers = winningNumbers.map {
                    LottoNumber.from(it)
                }.toList()

                assertThat(actual.winningLotto.lottoNumbers).usingRecursiveComparison()
                    .isEqualTo(expectedLottoNumbers)
            },
            {
                assertThat(actual.bonusNumber).usingRecursiveComparison()
                    .isEqualTo(LottoNumber.from(bonusNumber))
            },
        )
    }

    @Test
    fun `당첨번호6개와 보너스 번호 사이에 중복이 있으면 에러를 반환한다`() {
        // Given & When
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 1

        // Then
        assertThrows<IllegalArgumentException> {
            WinningLotto(
                Lotto.from(winningNumbers), LottoNumber.from(bonusNumber)
            )
        }
    }

    @Test
    fun `당첨로또번호에 구매한 로또를 주입하면 각 로또의 등수를 반환한다`() {
        // Given
        val bundle = LottoBundle(
            listOf(
                Lotto.from(listOf(1, 2, 3, 4, 5, 6)),
                Lotto.from(listOf(1, 2, 3, 4, 5, 7)),
                Lotto.from(listOf(1, 2, 3, 4, 5, 8)),
                Lotto.from(listOf(1, 2, 3, 4, 15, 18)),
                Lotto.from(listOf(1, 2, 3, 14, 15, 16)),
                Lotto.from(listOf(1, 12, 13, 14, 15, 16)),
                Lotto.from(listOf(11, 12, 13, 14, 15, 16)),
            )
        )

        val bonusNumber = 7
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val winningLotto = WinningLotto(
            Lotto.from(winningNumbers),
            LottoNumber.from(bonusNumber)
        )

        // When
        val actual = winningLotto.matchByRank(bundle)

        // Then
        assertThat(actual.containsAll(Rank.values().toList())).isTrue()
    }
}
