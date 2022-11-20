package calculator.extension

fun String.isPositiveNumeric() = this.all { it.isDigit() }
