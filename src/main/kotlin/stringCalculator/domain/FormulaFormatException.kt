package stringCalculator.domain

@Suppress("JavaIoSerializableObjectMustHaveReadResolve")
sealed class FormulaFormatException : Throwable() {
    object CustomSeparatorFormatException : FormulaFormatException()
    object NumberFormatException : FormulaFormatException()
    object WrongFormatException : FormulaFormatException()
    object NegativeNumberException : FormulaFormatException()
}
