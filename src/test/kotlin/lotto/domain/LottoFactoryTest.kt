package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.domain.model.LottoNumber
import lotto.util.NumberGenerator
import org.junit.jupiter.api.Assertions.assertThrows

class LottoFactoryTest : StringSpec({
    "{given} LottoFactory(totalLottoCount=5) {when} createLottoList() {then} 로또 총 5개 " {
        // Given
        val totalLottoCount = 5
        val expectedLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val fakeNumberGenerator = FakeRandomNumberGenerator(expectedLottoNumbers)
        val lottoFactory =
            LottoFactory(
                totalLottoCount = totalLottoCount,
                numberGenerator = fakeNumberGenerator,
            )

        // When
        val lottoList = lottoFactory.createLottoList()

        // Then
        lottoList shouldHaveSize totalLottoCount
        lottoList.forEach { lotto ->
            lotto.value shouldBe expectedLottoNumbers.map { LottoNumber(it) }
        }
    }

    "{given} LottoFactory(fakeNumberGenerator) {when} createLottoList() {then} 로또 번호 fake 번호들과 일치" {
        // Given
        val expectedLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val fakeNumberGenerator = FakeRandomNumberGenerator(expectedLottoNumbers)
        val lottoFactory =
            LottoFactory(
                totalLottoCount = 5,
                numberGenerator = fakeNumberGenerator,
            )

        // When
        val lottoList = lottoFactory.createLottoList()

        // Then
        lottoList.forEach { lotto -> lotto.value shouldBe expectedLottoNumbers.map { LottoNumber(it) } }
    }

    "{given} 정수 리스트, size=6, {when} LottoFactory.fromList() {then} Lotto 생성" {
        val list = listOf(1, 2, 3, 4, 5, 6)
        val result = LottoFactory.fromList(list)
        // assertTrue(result is Lotto) FIXME : this check is useless ?
    }

    "{given} 정수 리스트, size=10, {when} LottoFactory.fromList() {then} IllegalArgumentException 발생" {
        val list = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertThrows(IllegalArgumentException::class.java) {
            LottoFactory.fromList(list)
        }
    }
})

class FakeRandomNumberGenerator(private val numbers: List<Int>) : NumberGenerator {
    override fun getNumbers(count: Int): List<Int> = numbers
}
