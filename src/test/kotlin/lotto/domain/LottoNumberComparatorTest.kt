package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumberComparatorTest {

    @ParameterizedTest
    @CsvSource(
        "1,2,3,4,5,6 6",
        "6,5,4,3,2,1 6",
        "1,2,3,5,6,9 5",
        "7,8,9,10,11,12 0",
        delimiter = ' '
    )
    fun `두 개의 로또 번호를 입력받아서 같은 갯수가 몇개인지 찾는다`(inputList: String, answer: Int) {
        val numberList = inputList.split(',').map { it.toInt() }
        val comparativeList = listOf(1, 2, 3, 4, 5, 6)
        Assertions.assertThat(LottoNumberComparator.compare(numberList, comparativeList))
            .isEqualTo(answer)
    }
}
