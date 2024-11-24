package stringCalculator.domain

@Suppress("JavaIoSerializableObjectMustHaveReadResolve")
sealed class FormulaFormatException : Throwable() {
    object CustomSeparatorFormatException : FormulaFormatException()

    object NotNumberFormatException : FormulaFormatException()

    object UndefinedFormatException : FormulaFormatException()

    object NegativeNumberException : FormulaFormatException()
}
