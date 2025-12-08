package com.example.mylotto.service

import com.example.mylotto.enum.Rank
import com.example.mylotto.model.LottoNumber
import com.example.mylotto.model.LottoNumbers
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoServiceTest :
    BehaviorSpec({
        val lottoService = LottoService()

        Given("a purchase amount") {
            When("it is 5000 won and manual count is 2") {
                Then("it should generate 3 auto lotto tickets") {
                    val tickets = lottoService.generateAutoLottoNumbers(5000, 2)
                    tickets.size.shouldBe(3)
                }
            }

            When("it is not a multiple of 1000") {
                Then("it should throw an exception") {
                    val exception =
                        shouldThrow<IllegalArgumentException> {
                            lottoService.generateAutoLottoNumbers(1500, 1)
                        }
                    exception.message.shouldBe("Purchase amount must be a positive multiple of 1000.")
                }
            }

            When("it is not valid amount and count") {
                Then("it should throw an exception") {
                    val exception =
                        shouldThrow<IllegalArgumentException> {
                            lottoService.generateAutoLottoNumbers(2000, 3)
                        }
                    exception.message.shouldBe("Total purchase count must be equal or bigger than manual count.")
                }
            }
        }

        Given("a lotto ticket and winning numbers") {
            When("matching a single ticket") {
                Then("it should calculate the correct rank for each ticket") {
                    forAll(
                        row(
                            setOf(3, 11, 15, 29, 35, 44),
                            listOf(3, 11, 15, 29, 35, 44),
                            1,
                            Rank.FIRST,
                        ),
                        row(
                            setOf(3, 11, 15, 29, 35, 44),
                            listOf(3, 11, 15, 29, 35, 43),
                            44,
                            Rank.SECOND,
                        ),
                        row(
                            setOf(3, 11, 15, 29, 35, 7),
                            listOf(3, 11, 15, 29, 35, 44),
                            1,
                            Rank.THIRD,
                        ),
                        row(
                            setOf(3, 11, 15, 29, 10, 7),
                            listOf(3, 11, 15, 29, 35, 44),
                            1,
                            Rank.FOURTH,
                        ),
                        row(
                            setOf(3, 11, 15, 6, 10, 7),
                            listOf(3, 11, 15, 29, 35, 44),
                            1,
                            Rank.FIFTH,
                        ),
                        row(
                            setOf(1, 2, 4, 6, 8, 10),
                            listOf(3, 11, 15, 29, 35, 44),
                            1,
                            Rank.MISS,
                        ),
                    ) { lottoNumbers, winningNumbers, bonusNumber, expectedRank ->
                        val testLottoNumbers = LottoNumbers.of(lottoNumbers.map { LottoNumber(it) }.toList())
                        val testWinningNumbers = LottoNumbers.of(winningNumbers.map { LottoNumber(it) })

                        lottoService
                            .matchLottoTicket(testLottoNumbers, testWinningNumbers, bonusNumber)
                            .shouldBe(expectedRank)
                    }
                }
            }
        }
    })
