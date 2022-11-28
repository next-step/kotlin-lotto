package lotto.domain

import lotto.util.ErrorCode
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPurchaseTest {

    @ParameterizedTest
    @ValueSource(longs = [1, 2, 3, 100])
    fun initLottoList(count: Long) {
        val price = LottoPurchase.LOTTO_PRICE * count
        val result = LottoPurchase(price)

        assertThat(result.getLottoCount()).isEqualTo(count)
    }

    @ParameterizedTest
    @ValueSource(longs = [ 6, 7, 100])
    fun `LottoPurchase throw exception when manual count is greater then lottoCount`(manualLottoCount: Long) {
        val lottoCount = 5
        val price = LottoPurchase.LOTTO_PRICE * lottoCount

        val exception = assertThrows<IllegalArgumentException> {
            LottoPurchase(price, manualLottoCount)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.MANUAL_LOTTO_COUNT_EXCEPTION.errorMessage)
    }

    @ParameterizedTest
    @CsvSource(value = ["20, 10", "20,3", "2,0", "5,5"])
    fun `getAutoLottoCount is equal to lottoCount - manualLottoCount`(lottoCount: Long, manualLottoCount: Long) {
        val price = LottoPurchase.LOTTO_PRICE * lottoCount

        val autoLottoCountResult = LottoPurchase(price, manualLottoCount).getAutoLottoCount()

        assertThat(autoLottoCountResult).isEqualTo(lottoCount - manualLottoCount)
    }

    @ParameterizedTest
    @ValueSource(longs = [0, 1, 2, 3, 999])
    fun `generateLottoList throw exception when price less than 1000`(price: Long) {
        val exception = assertThrows<IllegalArgumentException> {
            LottoPurchase(price)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_MIN_LIMIT_EXCEPTION.errorMessage)
    }

    @ParameterizedTest
    @ValueSource(longs = [1001, 20003, 30003, 22333])
    fun `generateLottoList throw exception price cannot divide 1000`(price: Long) {
        val exception = assertThrows<IllegalArgumentException> {
            LottoPurchase(price)
        }

        assertThat(exception.message).isEqualTo(ErrorCode.LOTTO_PRICE_UNIT_EXCEPTION.errorMessage)
    }
}
