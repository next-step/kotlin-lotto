package calculator.common.model

class PositiveIntegers(
    private val positiveIntegerList: List<PositiveInteger>
) {

    fun multipleOperation(operateFunction: (PositiveInteger, PositiveInteger) -> PositiveInteger, initValue: PositiveInteger): PositiveInteger {
        var result = initValue
        for (number in positiveIntegerList) {
            result = operateFunction(result, number)
        }
        return result
    }
}
