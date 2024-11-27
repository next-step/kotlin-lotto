package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UserTest {
    @Test
    fun `구입금액만큼 자동 구매 가능`() {
        val initialAmount = Amount(3_000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val expectedLottos =
            Lottos(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(7, 8, 9, 10, 11, 12)),
                    Lotto(listOf(13, 14, 15, 16, 17, 18)),
                ),
            )

        val autoMachine: (Amount) -> Lottos = { _ -> expectedLottos }
        user.buyAutoLotto(autoMachine)

        assertAll(
            { assertThat(user.totalLottos).isEqualTo(expectedLottos) },
            { assertThat(user.totalLottoSize).isEqualTo(3) },
        )
    }

    @Test
    fun `수동 구매 가능`() {
        val initialAmount = Amount(3_000) // 사용자가 보유한 금액
        val user = User(initialAmount)
        val expectedLottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(7, 8, 9, 10, 11, 12)),
                Lotto(listOf(13, 14, 15, 16, 17, 18)),
            )
        )

        user.buyManualNumbers(expectedLottos)

        assertAll(
            { assertThat(user.totalLottos).isEqualTo(expectedLottos) },
            { assertThat(user.totalLottoSize).isEqualTo(3) },
        )
    }
}
