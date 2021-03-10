package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StoreTest {

    @Test
    fun `금액에 맞게 로또를 발급해준다`() {
        // given
        val nums = listOf(1, 2, 3, 4, 5, 6)
        val lotto = Lotto(nums)
        val expect = LottoPaper(listOf(lotto, lotto))

        // when
        val result: LottoPaper = Store(lottoNumsGenerator = StaticLottoNumsGenerator(nums)).sell(Money(2000))

        // then
        assertThat(result).isEqualTo(expect)
    }
}
