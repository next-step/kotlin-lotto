package lotto.extension

fun List<String>.toIntSet(): Set<Int> = this.map { it.toInt() }.toSet()
