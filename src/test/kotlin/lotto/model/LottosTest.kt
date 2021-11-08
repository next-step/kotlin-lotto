package lotto.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    @DisplayName("로또 1등 당첨되는 경우 확인")
    fun `check result of first winner`() {
        // given
        val price = Price(1000)
        val purchasedList = listOf(
            Lotto(
                listOf(
                    LottoNumber(10),
                    LottoNumber(1),
                    LottoNumber(13),
                    LottoNumber(23),
                    LottoNumber(33),
                    LottoNumber(43)
                )
            )
        )
        val winNumber = "10,1,13,23,33,43"
        val bonus = 4
        val winNumbers = WinNumber.inputWinNumber(winNumber, bonus)

        // when
        val lottos = Lottos.executeLottoComparison(purchasedList)

        // then
        Assertions.assertThat(lottos.compareLottoResult(price, winNumbers))
            .isEqualTo(LottoStatisticFormat(price, hashMapOf(LottoRank.FIRST to 1)))
    }

    @Test
    @DisplayName("로또 2등 당첨되는 경우 확인")
    fun `check result of second winner`() {
        // given
        val price = Price(1000)
        val purchasedList = listOf(
            Lotto(
                listOf(
                    LottoNumber(10),
                    LottoNumber(1),
                    LottoNumber(13),
                    LottoNumber(23),
                    LottoNumber(33),
                    LottoNumber(22)
                )
            )
        )
        val winNumber = "10,1,13,23,33,43"
        val bonus = 4
        val winNumbers = WinNumber.inputWinNumber(winNumber, bonus)

        // when
        val lottos = Lottos.executeLottoComparison(purchasedList)

        // then
        Assertions.assertThat(lottos.compareLottoResult(price, winNumbers))
            .isEqualTo(LottoStatisticFormat(price, hashMapOf(LottoRank.THIRD to 1)))
    }

    @Test
    @DisplayName("로또 3등 당첨되는 경우 확인")
    fun `check result of third winner`() {
        // given
        val price = Price(1000)
        val purchasedList = listOf(
            Lotto(
                listOf(
                    LottoNumber(10),
                    LottoNumber(1),
                    LottoNumber(13),
                    LottoNumber(23),
                    LottoNumber(9),
                    LottoNumber(22)
                )
            )
        )
        val winNumber = "10,1,13,23,33,43"
        val bonus = 4
        val winNumbers = WinNumber.inputWinNumber(winNumber, bonus)

        // when
        val lottos = Lottos.executeLottoComparison(purchasedList)

        // then
        Assertions.assertThat(lottos.compareLottoResult(price, winNumbers))
            .isEqualTo(LottoStatisticFormat(price, hashMapOf(LottoRank.FOURTH to 1)))
    }

    @Test
    @DisplayName("로또 4등 당첨되는 경우 확인")
    fun `check result of fourth winner`() {
        // given
        val price = Price(1000)
        val purchasedList = listOf(
            Lotto(
                listOf(
                    LottoNumber(10),
                    LottoNumber(1),
                    LottoNumber(13),
                    LottoNumber(7),
                    LottoNumber(9),
                    LottoNumber(22)
                )
            )
        )
        val winNumber = "10,1,13,23,33,43"
        val bonus = 4
        val winNumbers = WinNumber.inputWinNumber(winNumber, bonus)

        // when
        val lottos = Lottos.executeLottoComparison(purchasedList)

        // then
        Assertions.assertThat(lottos.compareLottoResult(price, winNumbers))
            .isEqualTo(LottoStatisticFormat(price, hashMapOf(LottoRank.FIFTH to 1)))
    }

    @Test
    @DisplayName("5개의 숫자가 일치하는 상황에서 나머지 하나의 숫자가 보너스 숫자와 일치하는 경우")
    fun `check result of bonus number winner`() {
        // given
        val price = Price(1000)
        val purchasedList = listOf(
            Lotto(
                listOf(
                    LottoNumber(10),
                    LottoNumber(1),
                    LottoNumber(13),
                    LottoNumber(23),
                    LottoNumber(33),
                    LottoNumber(22)
                )
            )
        )
        val winNumber = "10,1,13,23,33,43"
        val bonus = 22
        val winNumbers = WinNumber.inputWinNumber(winNumber, bonus)

        // when
        val lottos = Lottos.executeLottoComparison(purchasedList)

        // then
        Assertions.assertThat(lottos.compareLottoResult(price, winNumbers))
            .isEqualTo(LottoStatisticFormat(price, hashMapOf(LottoRank.SECOND to 1)))
    }

    @Test
    @DisplayName("로또 번호가 모두 같지 않은 경우")
    fun `check result of none winner`() {
        // given
        val price = Price(1000)
        val purchasedList = listOf(
            Lotto(
                listOf(
                    LottoNumber(45),
                    LottoNumber(42),
                    LottoNumber(24),
                    LottoNumber(7),
                    LottoNumber(9),
                    LottoNumber(22)
                )
            )
        )
        val winNumber = "10,1,13,23,33,43"
        val bonus = 6
        val winNumbers = WinNumber.inputWinNumber(winNumber, bonus)

        // when
        val lottos = Lottos.executeLottoComparison(purchasedList)

        // then
        Assertions.assertThat(lottos.compareLottoResult(price, winNumbers))
            .isEqualTo(LottoStatisticFormat(price, hashMapOf(LottoRank.MISS to 1)))
    }

    @Test
    @DisplayName("당첨 번호와 로또 숫자 비교하여 일치하는 개수 확인")
    fun `compare lotto item with win numbers`() {
        // given
        val purchasedNumber = Lotto(
            listOf(
                LottoNumber(10),
                LottoNumber(1),
                LottoNumber(13),
                LottoNumber(23),
                LottoNumber(33),
                LottoNumber(43)
            )
        )
        val winNumber = Lotto(
            listOf(
                LottoNumber(45),
                LottoNumber(14),
                LottoNumber(13),
                LottoNumber(23),
                LottoNumber(2),
                LottoNumber(43)
            )
        )

        val sameNumber = Lottos.compareNumber(purchasedNumber, winNumber)

        Assertions.assertThat(sameNumber).isEqualTo(3)
    }
}
