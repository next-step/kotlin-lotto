package service

class RandomNumberGenerator(override val startNumber: Int, override val endNumber: Int) :
    NumberGenerator {
    override fun getGeneratedNumber(): List<Int> =
        (startNumber..endNumber).map { it }.shuffled().slice(0..5)

}

interface NumberGenerator {
    fun getGeneratedNumber(): List<Int>
    val startNumber: Int
    val endNumber: Int
}