package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTicketTest {
    @ParameterizedTest
    @MethodSource("providedDuplicationNumbers")
    fun `로또 티켓은 중복된 번호로 생성되면 예외가 발생한다`(numbers: Set<Int>) {
        shouldThrow<IllegalArgumentException> {
            LottoTicket.from(numbers)
        }.also {
            it.message shouldBe "로또 티켓 번호가 잘못 입력되었습니다"
        }
    }

    @ParameterizedTest
    @MethodSource("providedWrongCountOfNumbers")
    fun `로또 티켓 번호는 6개가 아니면 예외가 발생한다`(numbers: Set<Int>) {
        shouldThrow<IllegalArgumentException> {
            LottoTicket.from(numbers)
        }.also {
            it.message shouldBe "로또 티켓 번호가 잘못 입력되었습니다"
        }
    }

    @Test
    fun `로또 티켓은 List와 Set으로 둘 다 생성 가능하다`() {
        val setOfLottoTicket = LottoTicket(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        val listOfLottoTicket = LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })
        (setOfLottoTicket == listOfLottoTicket) shouldBe true
    }

    @Test
    fun `로또 티켓을 생성하면 6개의 번호가 들어있다`() {
        val lottoTicket = LottoTicket.generateLottoNumber()
        lottoTicket shouldHaveSize 6
    }

    @ParameterizedTest
    @MethodSource("providedCoupleOfLottoTicket")
    fun `로또 티켓이 당첨 티켓과 몇개가 일치하는지 확인 할 수 있다`(
        lottoTicket: LottoTicket,
        winningLotto: LottoTicket,
        count: Int,
    ) {
        val matchCount = lottoTicket.calculateMatchCount(winningLotto)
        matchCount shouldBe count
    }

    @Test
    fun `로또 티켓의 번호가 6개 모두 일치하면 1등이다`() {
        val winningLotto = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val rank = lottoTicket.calculateRank(winningLotto)
        rank shouldBe LottoRank.FIRST_PLACE
        rank.prize shouldBe 2_000_000_000
    }

    @Test
    fun `로또 티켓의 번호가 5개 일치하면 2등이다`() {
        val winningLotto = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.from(setOf(1, 2, 3, 4, 5, 16))
        val rank = lottoTicket.calculateRank(winningLotto)
        rank shouldBe LottoRank.SECOND_PLACE
        rank.prize shouldBe 1_500_000
    }

    @Test
    fun `로또 티켓의 번호가 4개 일치하면 3등이다`() {
        val winningLotto = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.from(setOf(1, 2, 3, 4, 15, 16))
        val rank = lottoTicket.calculateRank(winningLotto)
        rank shouldBe LottoRank.THIRD_PLACE
        rank.prize shouldBe 50_000
    }

    @Test
    fun `로또 티켓의 번호가 3개 일치하면 4등이다`() {
        val winningLotto = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.from(setOf(1, 2, 3, 14, 15, 16))
        val rank = winningLotto.calculateRank(lottoTicket)
        rank shouldBe LottoRank.FOURTH_PLACE
        rank.prize shouldBe 5_000
    }

    @Test
    fun `로또 티켓의 번호가 2개 일치하면 꽝이다`() {
        val winningLotto = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.from(setOf(1, 2, 13, 14, 15, 16))
        val rank = lottoTicket.calculateRank(winningLotto)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }

    @Test
    fun `로또 티켓의 번호가 1개 일치하면 꽝이다`() {
        val winningLotto = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.from(setOf(1, 12, 13, 14, 15, 16))
        val rank = lottoTicket.calculateRank(winningLotto)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }

    @Test
    fun `로로또 티켓의 번호가 하나도 일치하지 않으면 꽝이다`() {
        val winningLotto = LottoTicket.from(setOf(1, 2, 3, 4, 5, 6))
        val lottoTicket = LottoTicket.from(setOf(11, 12, 13, 14, 15, 16))
        val rank = lottoTicket.calculateRank(winningLotto)
        rank shouldBe LottoRank.BLANK_PLACE
        rank.prize shouldBe 0
    }

    companion object {
        @JvmStatic
        fun providedDuplicationNumbers() =
            listOf(
                Arguments.arguments(setOf(1, 1, 2, 3, 4, 5)),
                Arguments.arguments(setOf(5, 5, 12, 13, 34, 35)),
                Arguments.arguments(setOf(11, 19, 24, 33, 44, 44)),
            )

        @JvmStatic
        fun providedWrongCountOfNumbers() =
            listOf(
                Arguments.arguments(setOf(1, 2, 3, 4, 5, 6, 7)),
                Arguments.arguments(setOf(3, 5, 7, 8, 9)),
                Arguments.arguments(setOf(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7)),
            )

        @JvmStatic
        fun providedCoupleOfLottoTicket() =
            listOf(
                Arguments.arguments(LottoTicket.from(setOf(1, 12, 13, 14, 15, 16)), LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), 1),
                Arguments.arguments(LottoTicket.from(setOf(1, 2, 13, 14, 15, 16)), LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), 2),
                Arguments.arguments(LottoTicket.from(setOf(1, 2, 3, 14, 15, 16)), LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), 3),
                Arguments.arguments(LottoTicket.from(setOf(1, 2, 3, 4, 15, 16)), LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), 4),
                Arguments.arguments(LottoTicket.from(setOf(1, 2, 3, 4, 5, 16)), LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), 5),
                Arguments.arguments(LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), LottoTicket.from(setOf(1, 2, 3, 4, 5, 6)), 6),
            )
    }
}
