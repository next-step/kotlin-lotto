package lotto

class Lotto {
    val numbers: List<Int> = (1..45).toList()
        .shuffled()
        .subList(0, 6)
}
