package com.example.mylotto.model

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec

class LottoWinningNumbersTest :
    FunSpec({
        test("success") {
            shouldNotThrowAny {
                LottoWinningNumbers.of(
                    listOf(
                        LottoNumber(3),
                        LottoNumber(11),
                        LottoNumber(15),
                        LottoNumber(29),
                        LottoNumber(35),
                        LottoNumber(44),
                    ),
                )
            }
        }

        test("winning numbers should not contain duplicates") {
            shouldThrow<IllegalArgumentException> {
                LottoWinningNumbers.of(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(5),
                    ),
                )
            }
        }

        test("winning numbers should contain exactly 6 numbers") {
            shouldThrow<IllegalArgumentException> {
                LottoWinningNumbers.of(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                    ),
                )
            }
            shouldThrow<IllegalArgumentException> {
                LottoWinningNumbers.of(
                    listOf(
                        LottoNumber(1),
                        LottoNumber(2),
                        LottoNumber(3),
                        LottoNumber(4),
                        LottoNumber(5),
                        LottoNumber(6),
                        LottoNumber(7),
                    ),
                )
            }
        }
    })
