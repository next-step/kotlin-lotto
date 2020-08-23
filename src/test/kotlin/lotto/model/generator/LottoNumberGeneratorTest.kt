package lotto.model.generator

import lotto.model.lotto.Lotto
import lotto.model.lotto.toNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {

    @DisplayName(value = "Auto Generate로 생성할 경우, Size는 Lotto.NUMBER_COUNT와 같아야한다. ")
    @Test
    fun randomNumberGeneratorCountTest() {
        val numberGenerator = RandomNumberGenerator
        assertThat(numberGenerator.generate().size).isSameAs(Lotto.NUMBER_COUNT)
    }

    @DisplayName(value = "Auto Generate로 생성할 경우, Number의 최대값과 최소값은 Lotto의 값을 따라야한다. ")
    @Test
    fun randomNumberGeneratorMinMaxTest() {
        val numberGenerator = RandomNumberGenerator
        assertThat(numberGenerator.generate().list.first().number).isLessThan(Lotto.MAX_NUMBER)
        assertThat(numberGenerator.generate().list.first().number).isGreaterThan(Lotto.MIN_NUMBER)
    }

    @DisplayName(value = "Manual Generate로 생성할 경우,지정된 숫자들과 같아야한다.")
    @Test
    fun manualNumberGeneratorTest() {
        val numbers = "1,2,3,4,5,6".toNumbers()

        val numberGenerator = ManualNumberGenerator(numbers)
        assertThat(numberGenerator.generate().list).containsAll(numbers.list)
    }
}
