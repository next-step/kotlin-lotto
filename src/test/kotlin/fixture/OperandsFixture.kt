package fixture

import calculator.domain.Operands

class OperandsFixture {

    companion object {
        val OPERANDS_SUM_OF_SIX = Operands(listOf(OperandFixture.ONE, OperandFixture.TWO, OperandFixture.THREE))
    }
}
