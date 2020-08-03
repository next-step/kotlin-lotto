package lotto

import lotto.generator.RandomNumberGenerater
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoNumberGeneratorTest {

    @DisplayName(value = "Auto Generate로 생성할 경우, Size는 Lotto.NUMBER_COUNT와 같아야한다.  ")
    @Test
    fun randomNumberGeneratorCountTest() {
        val numberGenerater = RandomNumberGenerater
        Assertions.assertThat(numberGenerater.generate().size).isSameAs(Lotto.NUMBER_COUNT)
    }

    @DisplayName(value = "Auto Generate로 생성할 경우, Number의 최대값과 최소값은 Lotto의 값을 따라야한다. ")
    @Test
    fun randomNumberGeneratorMinMaxTest() {
        val numberGenerater = RandomNumberGenerater
        Assertions.assertThat(numberGenerater.generate().list.max()).isLessThan(Lotto.MAX_NUMBER)
        Assertions.assertThat(numberGenerater.generate().list.min()).isGreaterThan(Lotto.MIN_NUMBER)
    }
}
