package lotto.component

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.doubles.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import lotto.model.*

class LottoTest : FunSpec({
    val analyzer = LottoResultAnalyzer()
    val lotto = Lotto(analyzer)

    test("1장의 로또 입력 시 1개의 당첨 결과 성공 테스트") {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val lottoNumbers = listOf(LottoNumbers.create(numbers))
        val winningNumbers = WinningNumbers.create(numbers)
        val bonusNumber = LottoNumber.from(7)

        val result: LottoResult = lotto.draw(lottoNumbers, winningNumbers, bonusNumber)

        result.lottoPrizes.size shouldBe 1
        result.revenueRate shouldBeGreaterThan -0.0
    }

    test("로또 번호가 보너스 번호를 포함할 때 당첨금 정상 반환 테스트") {
        val winningNumbers = WinningNumbers.create(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.from(7)

        forAll(
            row(listOf(bonusNumber.number, 9, 10, 11, 12, 13), LottoPrize.MISS),
            row(listOf(1, bonusNumber.number, 9, 10, 11, 12), LottoPrize.MISS),
            row(listOf(1, 2, bonusNumber.number, 10, 11, 12), LottoPrize.MISS),
            row(listOf(1, 2, 3, bonusNumber.number, 9, 10), LottoPrize.FIFTH),
            row(listOf(1, 2, 3, 4, bonusNumber.number, 9), LottoPrize.FOURTH)
        ) { numbers, answer ->
            val lottoNumbers = listOf(LottoNumbers.create(numbers))
            val result: LottoResult = lotto.draw(lottoNumbers, winningNumbers, bonusNumber)

            result.lottoPrizes[0] shouldBe answer
        }
    }

    test("2등일 경우 경우 당첨금 정상 반환 테스트") {
        val lottoNumbers = listOf(LottoNumbers.create(listOf(1, 2, 3, 4, 5, 7)))
        val winningNumbers = WinningNumbers.create(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.from(7)

        val result: LottoResult = lotto.draw(lottoNumbers, winningNumbers, bonusNumber)

        result.lottoPrizes[0] shouldBe LottoPrize.SECOND
    }

    test("3등일 경우 경우 당첨금 정상 반환 테스트") {
        val lottoNumbers = listOf(LottoNumbers.create(listOf(1, 2, 3, 4, 5, 7)))
        val winningNumbers = WinningNumbers.create(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber.from(8)

        val result: LottoResult = lotto.draw(lottoNumbers, winningNumbers, bonusNumber)

        result.lottoPrizes[0] shouldBe LottoPrize.THIRD
    }
})
