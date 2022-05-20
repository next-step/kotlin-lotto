package lotto.util

fun String.toBlankRemovedIntList() =
    this.split(",").map { it.trim().toInt() }

fun String.toBlankRemovedIntSet() =
    this.toBlankRemovedIntList().toSet()
