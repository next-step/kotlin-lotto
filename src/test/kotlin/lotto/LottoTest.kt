package lotto

import lotto.model.Lotto
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoTest {

    @DisplayName(value = "Lotto 생성시, Size는 Lotto.NUMBER_COUNT와 같아야한다.  ")
    @Test
    fun randomNumberGeneratorCountTest() {
        val lotto = Lotto.newAutoInstance()
        TODO("Not yet implemented")
    }
}
