package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.StringSpecTest

class LottoStoreTest : FreeSpec({
    "입력된 금액에 따라 로또를 여러장 구매한다" {
        val money = 14000

        val lottos = LottoStore.sell(money)

        assertThat(lottos).hasSize(14)
    }

    "입력된 금액이 1천원 단위가 아니면 예외를 발생시킨다" - {
        listOf(999, 1001, 1010, 1100, 1111)
            .forEach { money ->
                "입력값: $money" {
                    shouldThrow<NotEnoughMoneyException> { LottoStore.sell(money) }
                }
            }
    }
})