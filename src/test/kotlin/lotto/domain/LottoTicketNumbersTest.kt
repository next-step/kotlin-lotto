package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class LottoTicketNumbersTest : DescribeSpec({
    it("Int List 로 생성할수 있다") {
        // given
        val lottoNumbersByInt = listOf(1, 2, 3, 4, 5, 6)

        // when
        val lottoTicketNumbers = LottoTicketNumbers.ofInts(lottoNumbersByInt)

        // then
        lottoTicketNumbers.value.size shouldBe lottoNumbersByInt.size
        lottoTicketNumbers.value.map { it.value } shouldContainAll lottoNumbersByInt
    }

    describe("로또 번호가 포함 되었는지 알수 있다") {
        it("로또 번호가 포함 되면 True") {
            // given
            val lottoNumbersByInt = listOf(1, 2, 3, 4, 5, 6)
            val lottoTicketNumbers = LottoTicketNumbers.ofInts(lottoNumbersByInt)
            val includedLottoNumber = LottoTicketNumber(lottoNumbersByInt[0])

            // then
            lottoTicketNumbers.hasLottoNumber(includedLottoNumber) shouldBe true
        }
        it("로또 번호가 포함 돠지 않으면 False") {
            // given
            val lottoNumbersByInt = listOf(1, 2, 3, 4, 5, 6)
            val lottoTicketNumbers = LottoTicketNumbers.ofInts(lottoNumbersByInt)
            val notIncludedLottoNumber = LottoTicketNumber(10)

            // then
            lottoTicketNumbers.hasLottoNumber(notIncludedLottoNumber) shouldBe false
        }
    }

    describe("로또 번호가 안포함 되었는지  알수 있다") {
        it("로또 번호가 포함 되면 false") {
            // given
            val lottoNumbersByInt = listOf(1, 2, 3, 4, 5, 6)
            val lottoTicketNumbers = LottoTicketNumbers.ofInts(lottoNumbersByInt)
            val includedLottoNumber = LottoTicketNumber(lottoNumbersByInt[0])

            // then
            lottoTicketNumbers.hasNotLottoNumber(includedLottoNumber) shouldBe false
        }
        it("로또 번호가 포함 돠지 않으면 true") {
            // given
            val lottoNumbersByInt = listOf(1, 2, 3, 4, 5, 6)
            val lottoTicketNumbers = LottoTicketNumbers.ofInts(lottoNumbersByInt)
            val notIncludedLottoNumber = LottoTicketNumber(10)

            // then
            lottoTicketNumbers.hasNotLottoNumber(notIncludedLottoNumber) shouldBe true
        }
    }

    it("로또 숫자로 일치하는 번호 갯수를 알수 있다") {
        // given
        val lottoTicketNumbers = LottoTicketNumbers.ofInts(listOf(1, 2, 3, 4, 5, 6))
        val compareLottoNumbers = LottoTicketNumbers.ofInts(listOf(1, 2, 3, 10, 20, 30))

        // when
        val matchedCount = lottoTicketNumbers.findMatchedCount(compareLottoNumbers)

        // then
        matchedCount shouldBe 3
    }

    describe("validate") {
        it(" 알맞은 갯수의 로또 넘버를 가지고 있지 않다면 에러가 발생한다.") {
            // given
            val lottoNumbersByInt = listOf(1, 2, 3, 4, 5)

            // then
            shouldThrowExactly<IllegalArgumentException> {
                LottoTicketNumbers.ofInts(lottoNumbersByInt)
            }.shouldHaveMessage("로또 티켓은 6 개수의 로또 번호를 가지고 있어야 됩니다")
        }

        it(" 알맞은 갯수의 로또 넘버를 초과하여 가지고 있는 경우 에러가 발생한다.") {
            // given
            val lottoNumbersByInt = listOf(1, 2, 3, 4, 5, 6, 7)

            // then
            shouldThrowExactly<IllegalArgumentException> {
                LottoTicketNumbers.ofInts(lottoNumbersByInt)
            }.shouldHaveMessage("로또 티켓은 6 개수의 로또 번호를 가지고 있어야 됩니다")
        }

        it("중복된 로또 번호를 입력하면 에러가 발생한다") {
            // given
            val lottoNumbersByInt = listOf(1, 1, 1, 1, 1, 1)

            // then
            shouldThrowExactly<IllegalArgumentException> {
                LottoTicketNumbers.ofInts(lottoNumbersByInt)
            }.shouldHaveMessage("중복된 로또 번호가 있습니다")
        }
    }
})
