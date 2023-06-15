package lotto

import lotto.domain.BillSlot
import lotto.domain.LottoNumbers
import lotto.domain.LottoVendingMachine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {
    @ParameterizedTest
    @CsvSource(
        "14000, 1000, 14",
        "1300, 1000, 1",
        "1000, 2000, 0",
    )
    fun `주어진 금액으로 구입할 수 있는 로또 개수 구하기 테스트`(money: Int, lottoPrice: Int, numOfLotto: Int) {
        val billSlot = BillSlot(lottoPrice = lottoPrice)
        assertThat(billSlot.insertMoney(money))
            .isEqualTo(numOfLotto)
    }

    @Test
    fun `발급된 로또 번호는 6개여야 한다`() {
        assertThat(
            LottoNumbers.generate()
                .numbers
                .size
        ).isEqualTo(6)
    }

    @RepeatedTest(10)
    fun `발급된 로또 번호는 1보다 크거나 같고 45보다 작거나 같아야 한다`() {
        assertThat(
            LottoNumbers.generate()
                .numbers
                .any { it < 1 || 45 < it }
        ).isFalse()
    }

    @RepeatedTest(10)
    fun `발급된 로또 번호 중에는 중복된 수가 없어야 한다`() {
        assertThat(
            LottoNumbers.generate()
                .numbers
                .groupingBy { it }
                .eachCount()
                .any {
                    it.value != 1
                }
        ).isFalse()
    }

    @ParameterizedTest
    @CsvSource(
        "14000, 1000, 14",
        "1300, 1000, 1",
        "1000, 2000, 0",
    )
    fun `금액에 맞는 개수 만큼 로또 번호를 생성해야 한다`(money: Int, lottoPrice: Int, numOfLotto: Int) {
        assertThat(
            LottoVendingMachine(BillSlot(lottoPrice))
                .purchase(money)
                .size
        ).isEqualTo(numOfLotto)
    }
}
