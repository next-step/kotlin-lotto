package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FreeSpec
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import java.math.BigDecimal

internal class MoneyTest : FreeSpec({

    fun Money(value: Long): Money {
        return Money(value = BigDecimal.valueOf(value))
    }

    "돈은 0보다 작을 수 없다." - {
        listOf(
            -1,
            -10,
            -999
        ).forEach { value ->
            "Money 값 '$value'는 예외가 발생한다." {
                val exception =
                    shouldThrowExactly<IllegalArgumentException> { Money(value = BigDecimal.valueOf(value.toLong())) }

                exception.message shouldBe "돈은 0 보다 작을 수 없습니다."
            }
        }
    }

    "돈을 나눈 값을 내림된 정수로 반환한다." - {
        listOf(
            row(Money(7000), Money(1000), 7),
            row(Money(5500), Money(1000), 5),
            row(Money(200), Money(1000), 0),
        ).forEach { (firstMoney, secondMoney, result) ->
            "$firstMoney / $secondMoney = $result" {
                firstMoney.divideInt(secondMoney) shouldBe result
            }
        }
    }
})
