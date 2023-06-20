package com.nextstep.second.lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class LottoPurchaseTest {
    @ParameterizedTest
    @CsvSource(
        "13000, 0, 13",
        "12500, 1, 11",
        "8730, 3, 5"
    )
    fun `가격에 맞게 로또 구매를 할 수 있다`(money: Int, manualLottoCnt: Int, autoLottoCnt: Int) {
        // when
        val lottoPurchase = LottoPurchase.of(money, manualLottoCnt)

        // then
        lottoPurchase.manualLottoCount shouldBe manualLottoCnt
        lottoPurchase.autoLottoCount shouldBe autoLottoCnt
    }

    @ParameterizedTest
    @CsvSource(
        "13000, 110",
        "12500, 13",
        "8730, 9"
    )
    fun `돈에 비해 원하는 수동 발급 로또가 많아서 예외발생`(money: Int, manualLottoCnt: Int) {
        assertThrows<IllegalArgumentException> {
            LottoPurchase.of(money, manualLottoCnt)
        }
    }
}
