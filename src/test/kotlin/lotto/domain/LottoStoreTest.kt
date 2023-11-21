package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoStoreTest {

    @Test
    fun `LottoStore 에 돈을 지불하면 로또를 구매할 수 있다 (기본 가격은 1000원)`() {
        val lottos: Lottos = LottoStore.purchase(15000, emptyList(), RandomLottoGenerator())
        assertThat(lottos.size).isEqualTo(15)
    }

    @Test
    fun `LottoStore 에 3500원을 지불하면 3000원 어치 로또를 구매한다 (기본 가격은 1000원)`() {
        val lottos: Lottos = LottoStore.purchase(3500, emptyList(), RandomLottoGenerator())
        assertThat(lottos.size).isEqualTo(3)
    }

    @Test
    fun `LottoStore 에 1000원으로 로또를 수동 구매할 때 로또 번호의 범위를 넘어가면 IllegalArgumentException 발생한다`() {
        assertThrows<IllegalArgumentException> {
            LottoStore.purchase(
                1000,
                listOf(listOf(LottoNumber.LOTTO_UPPER_BOUND + 1, 2, 3, 4, 5, 6)),
                RandomLottoGenerator()
            )
        }
    }

    @Test
    fun `LottoStore 에 1000원으로 로또를 수동 구매할 때 지정한 번호로 구매가 된다`() {
        val lottoNumbers = listOf(45, 2, 3, 4, 5, 6) // 지정한 번호

        val lottos = LottoStore.purchase(1000, listOf(lottoNumbers), RandomLottoGenerator())

        assertThat(lottos.size).isEqualTo(1)
        assertThat(lottos.first().match(Lotto.fromInts(lottoNumbers))).isEqualTo(6)
    }

    @Test
    fun `LottoStore 에 3000원으로 로또를 구매할 때 로또 번호를 하나만 지정하면 한 장은 수동으로 지정된다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6) // 지정한 번호

        val lottos = LottoStore.purchase(3000, listOf(lottoNumbers), RandomLottoGenerator())
        assertThat(lottos.size).isEqualTo(3)
        assertThat(lottos.contains(Lotto.fromInts(lottoNumbers)))
    }

    @Test
    fun `LottoStore 에 1000원으로 로또를 구매할 때 수동으로 두 개 이상의 로또 번호를 지정하면 IllegalArgumentException 발생한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6) // 지정한 번호

        assertThrows<IllegalArgumentException> {
            LottoStore.purchase(
                1000,
                listOf(lottoNumbers, lottoNumbers),
                RandomLottoGenerator()
            )
        }
    }

    @Test
    fun `LottoStore 에 3000원으로 로또를 구매할 때 수동으로 1개를 지정하고 나머지도 수동으로 지정한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6) // 지정한 번호
        val manualLottoNumbers = listOf(45, 44, 43, 42, 41, 40) // 지정한 번호

        val lottos =
            LottoStore.purchase(3000, listOf(lottoNumbers, lottoNumbers), ManualLottoGenerator(listOf(manualLottoNumbers)))
        assertThat(lottos.size).isEqualTo(3)
        assertThat(lottos.contains(Lotto.fromInts(manualLottoNumbers)))
    }
}
