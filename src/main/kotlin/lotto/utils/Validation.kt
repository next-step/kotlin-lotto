package lotto.utils

object Validation {

    fun isNumeric(str: String) =
        str.all { Character.isDigit(it) }

    fun isWithInRange(number: Int, range: IntRange) =
        range.contains(number)

    fun isSameNumberOfArraysAndReferenceValue(numberOfArrays: Int, referenceValue: Int) =
        numberOfArrays == referenceValue

    fun isNotBlank(str: String) =
        str.isNotBlank()
}
