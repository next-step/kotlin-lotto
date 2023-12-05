package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.BonusLottoNumberCreateMachine
import lotto.domain.model.LottoNumbers

/**
 * 보너스 로또 번호 테스트
 * */
class BonusLottoNumberTest : FunSpec({

    test("당첨 로또 번호가 [1, 2, 3, 4, 5, 6]일 때 보너스 로또 번호에 `6`을 넣을 경우 당첨 번호와 보너스 로또 번호가 겹치기 때문에 예외(IllegalArgumentException)를 던진다.") {
        shouldThrow<IllegalArgumentException> {
            BonusLottoNumberCreateMachine.createBonusLottoNumber(
                6,
                LottoNumbers.valueOf(
                    setOf(
                        1, 2, 3, 4, 5, 6
                    )
                )
            )
        }
    }

    test("당첨 로또 번호가 [1, 2, 3, 4, 5, 6]일 때 보너스 로또 번호에 `7`을 넣을 경우 7을 가진 보너스 로또 번호가 생성되어야 한다.") {
        val bonusLottoNumber = BonusLottoNumberCreateMachine.createBonusLottoNumber(
            7,
            LottoNumbers.valueOf(
                setOf(
                    1, 2, 3, 4, 5, 6
                )
            )
        )
        bonusLottoNumber.value shouldBe 7
    }

})
