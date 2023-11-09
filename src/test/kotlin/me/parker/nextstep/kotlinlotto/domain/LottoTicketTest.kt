package me.parker.nextstep.kotlinlotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTicketTest : DescribeSpec({

    describe("automatic() 메서드") {
        it("6개의 랜덤한 로또 번호 숫자를 갖는 LottoTicket 객체를 생성한다.") {
            val lottoTicket = LottoTicket.automatic()

            lottoTicket.lottoNumbers.values.size shouldBe 6
        }
    }

    describe("manual() 메서드") {
        context("6개의 서로 다른 숫자 리스트가 주어지면") {
            it("해당 로또 번호 숫자를 갖는 LottoTicket 객체를 생성한다.") {
                val numbers = listOf(1, 2, 3, 4, 5, 6)
                val lottoTicket = LottoTicket.manual(numbers)

                lottoTicket.lottoNumbers.values.size shouldBe 6
                lottoTicket.lottoNumbers.values shouldBe numbers.map { LottoNumber(it) }
            }
        }

        context("6개 보다 많은 7개의 서로 다른 숫자 리스트가 주어지면") {
            it("예외가 발생한다.") {
                val numbers = listOf(1, 2, 3, 4, 5, 6, 7)

                shouldThrow<IllegalArgumentException> { LottoTicket.manual(numbers) }
                    .message shouldBe "로또 번호는 6개 까지만 가능합니다."
            }
        }

        context("6개 보다 적은 5개의 서로 다른 숫자 리스트가 주어지면") {
            it("예외가 발생한다.") {
                val numbers = listOf(1, 2, 3, 4, 5)

                shouldThrow<IllegalArgumentException> { LottoTicket.manual(numbers) }
                    .message shouldBe "로또 번호는 6개 까지만 가능합니다."
            }
        }

        context("6개의 번호를 갖지만 중복되는 번호가 주어지면") {
            it("예외가 발생한다.") {
                val numbers = listOf(1, 2, 3, 4, 5, 5)

                shouldThrow<IllegalArgumentException> { LottoTicket.manual(numbers) }
                    .message shouldBe "로또 번호는 중복되지 않아야 합니다."
            }
        }
    }

    describe("match() 메서드") {
        context("당첨 번호와 일치하는 번호가 6개인 경우") {
            it("1등이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))

                lottoTicket.match(winningLottoTicket) shouldBe LottoRank.FIRST
            }
        }

        context("당첨 번호와 일치하는 번호가 5개인 경우") {
            it("2등이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 7))

                lottoTicket.match(winningLottoTicket) shouldBe LottoRank.SECOND
            }
        }

        context("당첨 번호와 일치하는 번호가 4개인 경우") {
            it("3등이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 7, 8))

                lottoTicket.match(winningLottoTicket) shouldBe LottoRank.THIRD
            }
        }

        context("당첨 번호와 일치하는 번호가 3개인 경우") {
            it("4등이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 3, 7, 8, 9))

                lottoTicket.match(winningLottoTicket) shouldBe LottoRank.FOURTH
            }
        }

        context("당첨 번호와 일치하는 번호가 2개인 경우") {
            it("MISS이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 2, 7, 8, 9, 10))

                lottoTicket.match(winningLottoTicket) shouldBe LottoRank.MISS
            }
        }

        context("당첨 번호와 일치하는 번호가 1개인 경우") {
            it("MISS이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(1, 7, 8, 9, 10, 11))

                lottoTicket.match(winningLottoTicket) shouldBe LottoRank.MISS
            }
        }

        context("당첨 번호와 일치하는 번호가 0개인 경우") {
            it("MISS이다.") {
                val lottoTicket = LottoTicket.manual(listOf(1, 2, 3, 4, 5, 6))
                val winningLottoTicket = LottoTicket.manual(listOf(7, 8, 9, 10, 11, 12))

                lottoTicket.match(winningLottoTicket) shouldBe LottoRank.MISS
            }
        }
    }
})