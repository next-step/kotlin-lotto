package lotto

enum class Place(private val match: Int, private val price: Int) {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    ELSE(0, 0);
}
