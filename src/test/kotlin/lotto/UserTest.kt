package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UserTest {
    @Test
    fun `구입금액만큼 자동 구매 가능`() {
        val initialAmount = Amount(3000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val expectedLottos =
            Lottos(
                listOf(
                    Lotto(setOf(1, 2, 3, 4, 5, 6)),
                    Lotto(setOf(7, 8, 9, 10, 11, 12)),
                    Lotto(setOf(13, 14, 15, 16, 17, 18)),
                ),
            )

        val autoMachine: (Amount) -> Lottos = { _ -> expectedLottos }
        user.buyLotto(autoMachine)

        assertAll(
            { assertThat(user.totalLottos).isEqualTo(expectedLottos) },
            { assertThat(user.totalLottoSize).isEqualTo(3) },
        )
    }

    @Test
    fun `ranks 를 통해 당첨금액을 계산한다`() {
        val initialAmount = Amount(1000)
        val user = User(initialAmount)
        val lottoNumbers = List(6) { it + 1 }
        user.buyLotto { Lottos(listOf(Lotto(lottoNumbers.toSet()))) }

        val actual: LottoStatistics = user.statistics(Lotto(setOf(1, 2, 3, 4, 5, 6)))
        val expected =
            LottoStatistics(
                Ranks(
                    mapOf(
                        Rank.FIRST to 1,
                    ),
                ),
                initialAmount,
            )
        assertThat(actual).isEqualTo(expected)
    }
}
