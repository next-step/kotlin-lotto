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
                        LottoNumber.of(3),
                        LottoNumber.of(11),
                        LottoNumber.of(15),
                        LottoNumber.of(29),
                        LottoNumber.of(35),
                        LottoNumber.of(44),
                    ),
                )
            }
        }

        test("winning numbers should not contain duplicates") {
            shouldThrow<IllegalArgumentException> {
                LottoWinningNumbers.of(
                    listOf(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(5),
                    ),
                )
            }
        }

        test("winning numbers should contain exactly 6 numbers") {
            shouldThrow<IllegalArgumentException> {
                LottoWinningNumbers.of(
                    listOf(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                    ),
                )
            }
            shouldThrow<IllegalArgumentException> {
                LottoWinningNumbers.of(
                    listOf(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6),
                        LottoNumber.of(7),
                    ),
                )
            }
        }
    })
