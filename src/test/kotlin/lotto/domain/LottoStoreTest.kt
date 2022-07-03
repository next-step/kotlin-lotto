package lotto.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.tuple
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class LottoStoreTest {

    @Test
    fun `로또 번호 생성 규칙에 맞게 생성`() {
        val lottoList = LottoStore.buyLottos(LottoMoney(1000), Only6LottoNumberGenerator)
        assertThat(lottoList).hasSize(1)
        assertThat(lottoList.flatMap { it.lottoNumbers.map { lottoNumber -> lottoNumber.number } })
            .containsExactly(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `원하는 로또 개수만큼 생성`() {
        val lottoList = LottoStore.buyLottos(LottoMoney(10000), RandomLottoNumberGenerator)

        assertThat(lottoList).hasSize(10)
        assertThat(lottoList.flatMap { it.lottoNumbers }.map { it.number })
            .allMatch { it in LottoNumber.START_LOTTO_NUMBER..LottoNumber.END_LOTTO_NUMBER }
    }

    @Test
    fun `수동로또 구매`() {
        val (remainMoney, manualLottos) = LottoStore.buyManualLottos(
            LottoMoney(10000),
            listOf(listOf(1, 2, 3, 4, 5, 6), listOf(2, 3, 4, 5, 6, 7), listOf(3, 4, 5, 6, 7, 8))
        )

        assertThat(remainMoney).isEqualTo(LottoMoney(7000))
        assertThat(manualLottos).hasSize(3)
            .map(Lotto::lottoNumbers)
            .containsExactly(
                tuple(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }),
                tuple(listOf(2, 3, 4, 5, 6, 7).map { LottoNumber(it) }),
                tuple(listOf(3, 4, 5, 6, 7, 8).map { LottoNumber(it) }),
            )
    }

    @Test
    fun `입력 금액보다 많은 수동로또 구매 시 예외`() {
        assertThrows<IllegalArgumentException> {
            LottoStore.buyManualLottos(
                LottoMoney(2000),
                listOf(listOf(1, 2, 3, 4, 5, 6), listOf(2, 3, 4, 5, 6, 7), listOf(3, 4, 5, 6, 7, 8))
            )
        }.shouldHaveMessage("수동 로또는 구입금액 내에서만 구매하실 수 있습니다.")
    }

    private object Only6LottoNumberGenerator : LottoNumberGenerator {
        override fun generate(): List<LottoNumber> = (1..6).map { LottoNumber(it) }
    }
}
