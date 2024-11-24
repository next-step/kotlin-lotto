package stringCalculator.domain

@Suppress("JavaIoSerializableObjectMustHaveReadResolve")
sealed class FormulaFormatException : Throwable() {
    object CustomSeparatorFormatException : FormulaFormatException()

    object NotNumberFormatException : FormulaFormatException()

    object WrongFormatException : FormulaFormatException()

    object NegativeNumberException : FormulaFormatException()
}
