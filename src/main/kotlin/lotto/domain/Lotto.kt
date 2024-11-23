package lotto

// TODO: matchCount를 val (불변)으로 변경한다.
class Lotto private constructor(
    val pickNumbers: List<Int>,
    matchCount: Int
) {
    var matchCount: Int = matchCount
        private set

    fun updateMatchCount(value: Int): Lotto {
        return Lotto(pickNumbers, value)
    }

    override fun toString(): String {
        return "Lotto(pickNumbers=$pickNumbers, matchCount=$matchCount)"
    }

    companion object {
        fun of(pickNumbers: List<Int>): Lotto {
            return Lotto(pickNumbers = pickNumbers, matchCount = 0)
        }
    }
}
//class Lotto private constructor(
//    val pickNumbers: List<Int>,
//    val matchCount: Int
//) {
//    fun incrementMatchCount(): Lotto {
//        return Lotto(pickNumbers, matchCount + 1)
//    }
//
//    override fun toString(): String {
//        return "Lotto(pickNumbers=$pickNumbers, matchCount=$matchCount)"
//    }
//
//    companion object {
//        fun of(pickNumbers: List<Int>): Lotto {
//            return Lotto(pickNumbers = pickNumbers, matchCount = 0)
//        }
//    }
//}