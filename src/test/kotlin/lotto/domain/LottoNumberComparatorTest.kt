package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumberComparatorTest {

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5,6 true",
        "6,5,4,3,2,1 true",
        "1,2,3,5,6,9 false",
        delimiter = ' '
    )
    fun `두 개의 로또 번호를 입력받아서 로또 번호가 같은지 검증한다`(inputList: String, answer: Boolean) {
        val numberList = inputList.split(',').map { it.toInt() }
        val comparativeList = listOf(1, 2, 3, 4, 5, 6)
        Assertions.assertThat(LottoNumberComparator.compare(numberList, comparativeList))
            .isEqualTo(answer)
    }
}
