package calcaulator.util

fun String.toIntList(delimiter: Regex = Regex(",")) = this.split(delimiter)
    .filter { it.isNotBlank() }
    .map { it.trim().toInt() }
