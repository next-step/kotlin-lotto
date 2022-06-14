package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class WinningLottoNumbersTest : DescribeSpec({
    it("당첨 번호, 보너스 번호를 포함하여 생성자를 가지고 있다") {
        // given
        val winningNumbers = LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoTicketNumber(7)

        // when
        val winningLottoNumbers = WinningLottoNumbers(winningNumbers, bonusNumber)

        // then
        winningLottoNumbers.winningLottoNumbers.value.map { it.value } shouldBe winningNumbers.value.map { it.value }
        winningLottoNumbers.bonusLottoNumber shouldBe bonusNumber
    }

    it("로또 티켓 번호가 당첨 번호와 몇개 일치 하였는지 알 수 있다") {
        // given
        val winningNumbers = LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoTicketNumber(7)
        val winningLottoNumbers = WinningLottoNumbers(winningNumbers, bonusNumber)
        val threeMatchedNumbers = mutableListOf(10, 11, 12)
        threeMatchedNumbers.addAll(winningNumbers.value.take(3).map { it.value })

        // when
        val matchedCountOfWinning =
            winningLottoNumbers.getMatchedCountOfWinning(LottoTicketNumbers.ofInts(threeMatchedNumbers))

        // then
        matchedCountOfWinning shouldBe 3
    }
    it("로또 티켓 번호에 보너스 번호가 포함 되었는지 알 수 있다") {
        // given
        val winningNumbers = LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoTicketNumber(7)
        val winningLottoNumbers = WinningLottoNumbers(winningNumbers, bonusNumber)
        val lottoNumbersWithBonusBall: MutableList<Int> = mutableListOf()
        lottoNumbersWithBonusBall.addAll(winningNumbers.value.take(5).map { it.value })
        lottoNumbersWithBonusBall.add(bonusNumber.value)

        // then
        winningLottoNumbers.hasBonusNumber(LottoTicketNumbers.ofInts(lottoNumbersWithBonusBall)) shouldBe true
    }

    describe("팩토리 메소드") {
        it("String Type 에 팩토리 메소드를 지원하다") {
            // given
            val winningNumber = listOf(1, 2, 3, 4, 5, 6)
            val winningNumberString = "1, 2, 3 ,4, 5, 6"
            val winningNumberDelimiter = Delimiter(",")
            val bonusLottoNumber = 7
            val bonusLottoNumberString = bonusLottoNumber.toString()

            // when
            val winningLottoNumbers = WinningLottoNumbers.ofString(
                winningNumberString, winningNumberDelimiter, bonusLottoNumberString
            )

            // then
            winningLottoNumbers.winningLottoNumbers.value.map { it.value } shouldContainAll winningNumber
            winningLottoNumbers.bonusLottoNumber.value shouldBe bonusLottoNumber
        }
    }

    describe("validate") {
        it("보너스 번호가 당첨 번호와 같은 경우 에러 발생") {
            // given
            val winningNumbers = LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6))
            val bonusNumber = winningNumbers.value[0]

            // then
            shouldThrowExactly<IllegalArgumentException> {
                WinningLottoNumbers(winningNumbers, bonusNumber)
            }.shouldHaveMessage("보너스 번호(1)는 당첨번호 와 중복 될 수 없습니다")
        }
    }
})
