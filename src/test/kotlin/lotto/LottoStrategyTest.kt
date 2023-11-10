package lotto

import lotto.domain.LottoBuyStrategy
import lotto.domain.LottoList
import lotto.domain.LottoNumbers
import lotto.domain.ManualLotto
import lotto.domain.Money
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoStrategyTest {
    @Test
    fun `수동 로또의 개수는 전체 로또 개수를 넘기면 안된다`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                LottoBuyStrategy(
                    totalMoney = Money(1000),
                    LottoList(
                        listOf(
                            ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                            ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6))
                        )
                    )
                )
            }
    }

    @Test
    fun `자동 로또의 개수는 전체 로또 개수에서 수동 로또 개수를 뺀 것이다`() {
        Assertions.assertThat(
            LottoBuyStrategy(
                totalMoney = Money(2000), LottoList(
                    listOf(
                        ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                        ManualLotto(LottoNumbers(1, 2, 3, 4, 5, 6))
                    )
                )
            ).autoCount
        ).isEqualTo(0)
    }
}
