package lotto.view.input.parser

import lotto.model.data.Lotto
import lotto.model.data.Policy

open class BonusNumberInputParser(
    policy: Policy,
    private val lotto: Lotto
) : IntInputParser(policy.rangeOfNumbers) {

    override fun parseValue(inputString: String?): Int {
        val inputNumber = super.parseValue(inputString)
        require(inputNumber !in lotto.numbers) { "보너스 번호는 로또 번호와 겹칠 수 없습니다." }
        return inputNumber
    }
}
