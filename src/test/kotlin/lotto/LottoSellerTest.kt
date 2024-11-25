package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoSeller
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoSellerTest {
    @Test
    fun `로또 구매 갯수는 구매금액을 한장 가격으로 나눈 값이다`() {
        val lottoSeller = LottoSeller()
        assertThat(lottoSeller.getLottoPurchaseCount(5_000)).isEqualTo(5)
    }

    @Test
    fun sellLottosTest() {
        val lottoSeller = LottoSeller { LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }) }
        val lottos = lottoSeller.sellLottos(5_000)
        lottos.lottos.forEach {
            assertThat(it.numbers.lottoNumbers[0].number).isEqualTo(1)
            assertThat(it.numbers.lottoNumbers[1].number).isEqualTo(2)
            assertThat(it.numbers.lottoNumbers[2].number).isEqualTo(3)
            assertThat(it.numbers.lottoNumbers[3].number).isEqualTo(4)
            assertThat(it.numbers.lottoNumbers[4].number).isEqualTo(5)
            assertThat(it.numbers.lottoNumbers[5].number).isEqualTo(6)
        }
    }

    @Test
    fun `로또 판매자는 수동방식으로 로또를 판매한다`() {
        val lottoSeller = LottoSeller()
        val lottos =
            lottoSeller.sellLottos(
                3000,
                listOf(
                    LottoNumbers.of(listOf(1, 2, 3, 4, 5, 6)),
                    LottoNumbers.of(listOf(1, 2, 3, 4, 5, 7)),
                ),
            )
        assertThat(lottos.lottos[0].numbers.lottoNumbers[0].number).isEqualTo(1)
        assertThat(lottos.lottos[0].numbers.lottoNumbers[1].number).isEqualTo(2)
        assertThat(lottos.lottos[0].numbers.lottoNumbers[2].number).isEqualTo(3)
        assertThat(lottos.lottos[0].numbers.lottoNumbers[3].number).isEqualTo(4)
        assertThat(lottos.lottos[0].numbers.lottoNumbers[4].number).isEqualTo(5)
        assertThat(lottos.lottos[0].numbers.lottoNumbers[5].number).isEqualTo(6)

        assertThat(lottos.lottos[1].numbers.lottoNumbers[0].number).isEqualTo(1)
        assertThat(lottos.lottos[1].numbers.lottoNumbers[1].number).isEqualTo(2)
        assertThat(lottos.lottos[1].numbers.lottoNumbers[2].number).isEqualTo(3)
        assertThat(lottos.lottos[1].numbers.lottoNumbers[3].number).isEqualTo(4)
        assertThat(lottos.lottos[1].numbers.lottoNumbers[4].number).isEqualTo(5)
        assertThat(lottos.lottos[1].numbers.lottoNumbers[5].number).isEqualTo(7)
    }
}
