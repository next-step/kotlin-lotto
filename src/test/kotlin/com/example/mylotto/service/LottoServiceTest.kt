package com.example.mylotto.service

import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoNumber
import com.example.mylotto.model.LottoTicket
import com.example.mylotto.model.LottoTicketOrder
import com.example.mylotto.model.LottoWinningNumbers
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoServiceTest :
    BehaviorSpec({
        val lottoService = LottoService()

        given("a purchase amount") {
            `when`("it is 5000 won") {
                then("it should return 5") {
                    val count = lottoService.calculateCount(5000)
                    count.shouldBe(5)
                }
            }

            `when`("it is not a multiple of 1000") {
                then("it should throw an exception") {
                    shouldThrow<IllegalArgumentException> {
                        lottoService.calculateCount(1500)
                    }
                }
            }
        }

        given("an order") {
            `when`("generate tickets using the order") {
                then("ticket count should match the order") {
                    val manualTickets =
                        listOf(
                            LottoTicket.of(
                                setOf(
                                    LottoNumber.of(1),
                                    LottoNumber.of(2),
                                    LottoNumber.of(3),
                                    LottoNumber.of(4),
                                    LottoNumber.of(5),
                                    LottoNumber.of(6),
                                ),
                            ),
                            LottoTicket.of(
                                setOf(
                                    LottoNumber.of(7),
                                    LottoNumber.of(8),
                                    LottoNumber.of(9),
                                    LottoNumber.of(10),
                                    LottoNumber.of(11),
                                    LottoNumber.of(12),
                                ),
                            ),
                        )
                    val automaticCount = 3
                    val totalCount = 5

                    val tickets = lottoService.generateLottoTickets(LottoTicketOrder(manualTickets, automaticCount))

                    tickets.size.shouldBe(totalCount)
                    tickets.take(manualTickets.size).shouldBe(manualTickets)
                }
            }
        }

        given("a lotto ticket and winning numbers") {
            `when`("matching a single ticket") {
                then("it should calculate the correct rank for each ticket") {
                    forAll(
                        row(
                            setOf(3, 11, 15, 29, 35, 44),
                            listOf(3, 11, 15, 29, 35, 44),
                            7,
                            Rank.FIRST,
                        ),
                        row(
                            setOf(3, 7, 15, 29, 35, 44),
                            listOf(3, 11, 15, 29, 35, 44),
                            7,
                            Rank.SECOND,
                        ),
                        row(
                            setOf(3, 11, 15, 29, 35, 43),
                            listOf(3, 11, 15, 29, 35, 44),
                            7,
                            Rank.THIRD,
                        ),
                        row(
                            setOf(3, 11, 15, 29, 10, 7),
                            listOf(3, 11, 15, 29, 35, 44),
                            7,
                            Rank.FOURTH,
                        ),
                        row(
                            setOf(3, 11, 15, 6, 10, 7),
                            listOf(3, 11, 15, 29, 35, 44),
                            7,
                            Rank.FIFTH,
                        ),
                        row(
                            setOf(1, 2, 4, 6, 8, 10),
                            listOf(3, 11, 15, 29, 35, 44),
                            7,
                            Rank.MISS,
                        ),
                    ) { ticketNumbers, winningNumbers, bonusNumber, expectedRank ->
                        val testTicket = LottoTicket.of(ticketNumbers.map(LottoNumber::of).toSet())
                        val testWinningNumbers = LottoWinningNumbers.of(winningNumbers.map(LottoNumber::of), LottoNumber.of(bonusNumber))

                        lottoService.matchLottoTicket(testTicket, testWinningNumbers).shouldBe(expectedRank)
                    }
                }
            }
        }
    })
