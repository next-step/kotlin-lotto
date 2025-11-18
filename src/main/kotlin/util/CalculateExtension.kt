package util

fun Double.round(decimal: Int) = "%.${decimal}f".format(this).toDouble()
