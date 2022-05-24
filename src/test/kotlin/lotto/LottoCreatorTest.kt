package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoCreatorTest {

    @Test
    fun `로또 번호는 중복되지 않는 1-45 숫자 6개를 선택한다`() {
        val autoCreatedLotto = LottoCreator.autoCreate()
        Assertions.assertThat(autoCreatedLotto.numbers.size).isEqualTo(6)
    }

    @Test
    fun `생성한 로또번호는 오름차순으로 받는다`() {
        val autoCreatedLottoNumbers = LottoCreator.autoCreate().numbers

        val sortedList = autoCreatedLottoNumbers.sorted()

        for (number in autoCreatedLottoNumbers.indices) {
            autoCreatedLottoNumbers[number] == sortedList[number]
        }
    }
}
