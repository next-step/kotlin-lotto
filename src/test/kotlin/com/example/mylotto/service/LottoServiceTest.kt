package com.example.mylotto.service

import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoNumber
import com.example.mylotto.model.LottoTicket
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
                then("it should generate 5 lotto tickets") {
                    val tickets = lottoService.generateLottoTickets(5000)
                    tickets.size.shouldBe(5)
                }
            }

            `when`("it is not a multiple of 1000") {
                then("it should throw an exception") {
                    shouldThrow<IllegalArgumentException> {
                        lottoService.generateLottoTickets(1500)
                    }
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
                            Rank.FIRST,
                        ),
                        row(
                            setOf(3, 11, 15, 29, 35, 7),
                            listOf(3, 11, 15, 29, 35, 44),
                            Rank.THIRD,
                        ),
                        row(
                            setOf(3, 11, 15, 29, 10, 7),
                            listOf(3, 11, 15, 29, 35, 44),
                            Rank.FOURTH,
                        ),
                        row(
                            setOf(3, 11, 15, 6, 10, 7),
                            listOf(3, 11, 15, 29, 35, 44),
                            Rank.FIFTH,
                        ),
                        row(
                            setOf(1, 2, 4, 6, 8, 10),
                            listOf(3, 11, 15, 29, 35, 44),
                            Rank.MISS,
                        ),
                    ) { ticketNumbers, winningNumbers, expectedRank ->
                        val testTicket = LottoTicket(ticketNumbers.map { LottoNumber(it) }.toSet())
                        val testWinningNumbers = LottoWinningNumbers.of(winningNumbers.map { LottoNumber(it) })

                        lottoService.matchLottoTicket(testTicket, testWinningNumbers).shouldBe(expectedRank)
                    }
                }
            }
        }
    })
