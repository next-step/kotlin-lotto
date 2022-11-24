package lotto.extension

fun String.isPositiveNumeric() = this.all { it.isDigit() }
