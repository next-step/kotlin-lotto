package lotto

import lotto.domain.LottoCustomerInput
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoSeller
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoSellerTest {
    @Test
    fun `로또 구매 갯수는 구매금액을 한장 가격으로 나눈 값이다`() {
        val lottoCustomerInput = LottoCustomerInput(5_000)
        assertThat(lottoCustomerInput.getLottoAutoCount()).isEqualTo(5)
    }

    @Test
    fun sellLottosTest() {
        val lottoCustomerInput = LottoCustomerInput(5_000)
        val lottoSeller = LottoSeller { LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()) }
        val lottos = lottoSeller.sellLottos(lottoCustomerInput)
        lottos.lottos.forEach {
            assertThat(
                it.numbers.lottoNumbers.map { lottoNumber ->
                    lottoNumber.number
                },
            ).containsExactly(1, 2, 3, 4, 5, 6)
        }
    }

    @Test
    fun `로또 판매자는 수동방식으로 로또를 판매한다`() {
        val lottoSeller = LottoSeller()
        val lottoCustomerInput =
            LottoCustomerInput(
                2000,
                listOf(
                    LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)),
                    LottoNumbers.of(listOf(1, 2, 3, 4, 5, 7)),
                ),
            )
        val lottos = lottoSeller.sellLottos(lottoCustomerInput)
        assertThat(lottos.lottos[0].numbers.lottoNumbers.map { lottoNumber -> lottoNumber.number }).containsExactly(1, 2, 3, 4, 5, 6)
        assertThat(lottos.lottos[1].numbers.lottoNumbers.map { lottoNumber -> lottoNumber.number }).containsExactly(1, 2, 3, 4, 5, 7)
    }
}
