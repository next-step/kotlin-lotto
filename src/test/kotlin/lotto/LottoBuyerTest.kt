package lotto

import lotto.domain.LottoBuyer
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoBuyerTest {
    @ParameterizedTest
    @ValueSource(ints = [5, 20, 100])
    fun `1) 수동 0개, 자동은 N개 로또 구매하기`(autoLottoCount: Int) {
        Assertions.assertThat(LottoBuyer.buyer(emptyList(), autoLottoCount).lottoBuyList.size).isEqualTo(autoLottoCount)
    }

    @ParameterizedTest
    @ValueSource(ints = [5, 20, 100])
    fun `2) 수동 1개, 자동은 N개 로또 구매하기`(autoLottoCount: Int) {
        val manualLottoNumber = listOf(
            LottoNumbers(
                listOf(
                    LottoNumber.from(3),
                    LottoNumber.from(20),
                    LottoNumber.from(1),
                    LottoNumber.from(15),
                    LottoNumber.from(11),
                    LottoNumber.from(31)
                )
            )
        )

        Assertions.assertThat(LottoBuyer.buyer(manualLottoNumber, autoLottoCount).lottoBuyList.size).isEqualTo(autoLottoCount + 1)
    }
}
