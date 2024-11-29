package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import lotto.util.NumberGenerator

class LottoFactoryTest : StringSpec({
    "{given} LottoFactory(totalLottoCount=5) {when} createLottoList() {then} 로또 총 5개 " {
        // Given
        val totalLottoCount = 5
        val expectedLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val fakeNumberGenerator = FakeRandomNumberGenerator(expectedLottoNumbers)
        val lottoFactory = LottoFactory(
            totalLottoCount = totalLottoCount,
            randomNumberGenerator = fakeNumberGenerator
        )

        // When
        val lottoList = lottoFactory.createLottoList()

        // Then
        lottoList shouldHaveSize totalLottoCount
        lottoList.forEach { lotto ->
            lotto.value shouldBe expectedLottoNumbers
        }
    }

    "{given} LottoFactory(fakeNumberGenerator) {when} createLottoList() {then} 로또 번호 fake 번호들과 일치" {
        // Given
        val expectedLottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        val fakeNumberGenerator = FakeRandomNumberGenerator(expectedLottoNumbers)
        val lottoFactory = LottoFactory(
            totalLottoCount = 5, // 임의값
            randomNumberGenerator = fakeNumberGenerator
        )

        // When
        val lottoList = lottoFactory.createLottoList()

        // Then
        lottoList.forEach { lotto -> lotto.value shouldBe expectedLottoNumbers }
    }
})

class FakeRandomNumberGenerator(private val numbers: List<Int>) : NumberGenerator {
    override fun getNumbers(count: Int): List<Int> = numbers
}