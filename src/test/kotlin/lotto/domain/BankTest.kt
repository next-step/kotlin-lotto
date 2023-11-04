package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class BankTest : FunSpec({
    test("수익이 저장된다") {
        forAll(
            row(0, 1000),
            row(1000, 2000)
        ) { initialIncome, amountToAdd ->
            val bank = Bank(initialIncome)

            val result = bank.save(Amount(amountToAdd))

            result shouldBe initialIncome + amountToAdd
        }
    }
})
