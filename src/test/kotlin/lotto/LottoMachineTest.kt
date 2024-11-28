package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoMachineTest {
    @Test
    fun `자동구매 가능`() {
        var amount = Amount(2_000)
        val expectedLottos =
            Lottos(
                listOf(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    Lotto(listOf(7, 8, 9, 10, 11, 12)),
                ),
            )
        val autoMachine: (Amount) -> Lottos = { _ -> expectedLottos }

        val lottoMachine = LottoMachine(autoMachine)
        val actual = lottoMachine.autoGenerate(amount)

        assertThat(actual).isEqualTo(expectedLottos)
    }

    @Test
    fun `숫자를 통해 Lotto 생성가능`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val expected = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val lottoMachine = LottoMachine()

        val actual = lottoMachine.createLotto(numbers)

        assertThat(actual).isEqualTo(expected)
    }
}
