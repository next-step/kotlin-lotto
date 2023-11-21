package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoStoreTest {

    @Test
    fun `LottoStore 에 돈을 지불하면 로또를 구매할 수 있다 (기본 가격은 1000원)`() {
        val lottos: Lottos = LottoStore.purchase(15000, RandomLottoGenerator())
        assertThat(lottos.size).isEqualTo(15)
    }

    @Test
    fun `LottoStore 에 3500원을 지불하면 3000원 어치 로또를 구매한다 (기본 가격은 1000원)`() {
        val lottos: Lottos = LottoStore.purchase(3500, RandomLottoGenerator())
        assertThat(lottos.size).isEqualTo(3)
    }

    @Test
    fun `LottoStore 에 1000원으로 로또를 수동 구매할 때 로또 번호의 범위를 넘어가면 IllegalArgumentException 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoStore.purchase(
                1000,
                ManualLottoGenerator(listOf(LottoNumber.LOTTO_UPPER_BOUND + 1, 2, 3, 4, 5, 6))
            )
        }
    }

    @Test
    fun `LottoStore 에 1000원으로 로또를 수동 구매할 때 지정한 번호로 구매가 된다`() {
        val lottoNumbers = listOf(45, 2, 3, 4, 5, 6) // 지정한 번호

        val lottos = LottoStore.purchase(1000, ManualLottoGenerator(lottoNumbers))

        assertThat(lottos.size).isEqualTo(1)
        val purchaseLottos = lottos.getLottos()
        assertThat(purchaseLottos.first().match(Lotto.fromInts(lottoNumbers))).isEqualTo(6)
    }

    @Test
    fun `LottoStore 에 3000원으로 로또를 수동 구매할 때 로또 번호를 하나만 지정하면 IllegalArgumentException 이 발생한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6) // 지정한 번호

        assertThrows<IllegalArgumentException> { LottoStore.purchase(3000, ManualLottoGenerator(lottoNumbers)) }
    }
}
