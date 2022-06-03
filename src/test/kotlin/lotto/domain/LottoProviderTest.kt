package lotto.domain

import lotto.domain.numbers.LottoNumbers
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class LottoProviderTest {
    @Nested
    @DisplayName("수동으로 구매한 로또가 없을 경우")
    inner class WithoutCustomLotto {
        @Test
        fun `로또 1장의 가격은 1000원이다`() {
            val price = LottoProvider.LOTTO_PRICE

            assertThat(price).isEqualTo(1000)
        }

        @Test
        fun `구입금액으로 살 수 있는 로또 개수를 계산할 수 있다`() {
            val payment = 14300

            assertThat(LottoProvider(payment).numberOfAutomaticLottos).isEqualTo(14)
        }

        @Test
        fun `구입한 로또의 수 만큼 로또를 생성한다`() {
            val payment = 20500
            val provider = LottoProvider(payment)

            assertThat(provider.lottos).hasSize(provider.numberOfAutomaticLottos)
        }

        @Test
        fun `구입 금액이 로또 금액보다 낮다면 로또를 살 수 없다`() {
            val provider = LottoProvider(0)

            assertThat(provider.numberOfAutomaticLottos).isEqualTo(0)
        }
    }

    @Nested
    @DisplayName("수동으로 구매한 로또가 있을 경우")
    inner class WithCustomLotto {
        @Test
        fun `수동으로 구매할 로또 수만큼 로또를 생성한 후 나머지는 자동생성한다`() {
            val totalPayment = 5000

            val customLottoNumbers = listOf(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                LottoNumbers(listOf(45, 44, 43, 42, 41, 40))
            )

            val lottoProvider = LottoProvider(totalPayment, customLottoNumbers)

            assertThat(lottoProvider.numberOfCustomLottos).isEqualTo(2)
            assertThat(lottoProvider.numberOfAutomaticLottos).isEqualTo(3)
            assertThat(lottoProvider.lottos.size).isEqualTo(5)
        }
        @Test
        fun `사용자가 입력한 번호로 수동 로또를 생성한다`() {
            val totalPayment = 5000

            val customLottoNumbers = listOf(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                LottoNumbers(listOf(45, 44, 43, 42, 41, 40))
            )

            val lottoProvider = LottoProvider(totalPayment, customLottoNumbers)

            assertThat(lottoProvider.lottos.map { it.numbers.list }).containsAll(customLottoNumbers.map { it.list })
        }

        @Test
        fun `만약 구매 금액보다 많은 수동 로또 수가 주어졌을 경우 IllegalArgumentException 이 발생한다`() {
            val totalPayment = 1000

            val customLottoNumbers = listOf(
                LottoNumbers(listOf(1, 2, 3, 4, 5, 6)),
                LottoNumbers(listOf(45, 44, 43, 42, 41, 40))
            )

            assertThatIllegalArgumentException().isThrownBy { LottoProvider(totalPayment, customLottoNumbers) }
        }
    }
}
