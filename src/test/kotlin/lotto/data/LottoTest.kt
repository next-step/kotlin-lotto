package lotto.data

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun treeSetTest() {
        val numberList = listOf(3, 5, 7, 4, 2, 4, 6, 4, 3)
        val linkedHashSet = LinkedHashSet(numberList)
        println(linkedHashSet)
    }

    @Test
    fun `6개로 구성되지 않는 번호 구성을 받았다면, 로또를 생성했을 때, 예외를 던진다`() {
        // given : 6개로 구성되지 않은 번호 구성을 받는다.
        val selectNumberList = listOf(1, 2, 3, 4, 5, 6, 7)

        // when : 로또번호를 구성한다.
        val actual = runCatching { Lotto(LottoNumber.createLottoNumbers(selectNumberList)) }.exceptionOrNull()

        // then : 예외를 던진다.
        Assertions.assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }

    @Test
    fun `중복값을 포함한 6개의 번호 구성을 받았다면, 로또를 생성했을 때, 예외를 던진다`() {
        // given : 중복값을 포함한 6개의 번호 구성을 받는다.
        val selectNumberList = listOf(1, 2, 3, 4, 6, 6)

        // when : 로또번호를 구성한다.
        val actual = runCatching { Lotto(LottoNumber.createLottoNumbers(selectNumberList)) }.exceptionOrNull()

        // then : 예외를 던진다.
        Assertions.assertThat(actual).isInstanceOf(IllegalArgumentException()::class.java)
    }
}
