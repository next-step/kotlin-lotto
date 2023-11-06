package lotto

class Lotto {
    val price: Int = 1000
    val numbers: List<Int> = (1..45).toList()
        .shuffled()
        .subList(0, 6)
}
