package calculator.common.model

class PositiveIntegers(
    private val positiveIntegerList: List<PositiveInteger>
) {

    fun multiplePlus(plusFunction: (PositiveInteger, PositiveInteger) -> PositiveInteger): PositiveInteger {
        var result = PositiveInteger(0)
        for (number in positiveIntegerList) {
            result = plusFunction(result, number)
        }
        return result
    }
}
